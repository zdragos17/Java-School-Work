package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RouteManager {


    private static final String BASE_DIR = "routes/";
    private static final ObjectMapper mapper = new ObjectMapper();


    public static void createRoute(String routeName) {
        File folder = new File(BASE_DIR + routeName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }


    public static void deleteRoute(String routeName) {
        File folder = new File(BASE_DIR + routeName);
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File f : files) {
                    f.delete();
                }
            }
            folder.delete();
        }
    }


    public static void addWaypoint(String routeName, Waypoint wp) throws IOException {
        String fileName = BASE_DIR + routeName + "/" + String.format("%03d", wp.getIndex()) + "_" + wp.getName() + ".json";
        File file = new File(fileName);
        if (!file.exists()) {
            mapper.writeValue(new FileWriter(file), wp);
        }
    }


    public static double calculateTotalDistance(List<Waypoint> waypoints) {
        double total = 0;
        for (int i = 1; i < waypoints.size(); i++) {
            Waypoint a = waypoints.get(i - 1);
            Waypoint b = waypoints.get(i);
            total += WaypointDistanceCalculator.calculateDistance(
                    a.getLatitude(), a.getLongitude(),
                    b.getLatitude(), b.getLongitude());
        }
        return total;
    }


    public static List<String> listRoutes() {
        List<String> routes = new ArrayList<>();
        File base = new File(BASE_DIR);
        if (base.exists()) {
            File[] folders = base.listFiles();
            if (folders != null) {
                for (File f : folders) {
                    if (f.isDirectory()) {
                        routes.add(f.getName());
                    }
                }
            }
        }
        return routes;
    }
}
