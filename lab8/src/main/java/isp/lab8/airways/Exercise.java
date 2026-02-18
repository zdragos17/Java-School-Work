package isp.lab8.airways;

import java.io.IOException;
import java.util.List;

public class Exercise {
    public static void main(String[] args) throws IOException {
        String routeName = "LRCL-LROP";
        RouteManager.createRoute(routeName);

        RouteManager.addWaypoint(routeName, new Waypoint(1, "LRCL", 46.7852, 23.6862, 415));
        RouteManager.addWaypoint(routeName, new Waypoint(2, "TASOD", 47.0548, 23.9212, 10460));
        RouteManager.addWaypoint(routeName, new Waypoint(3, "SOPAV", 46.9804, 24.7365, 10900));
        RouteManager.addWaypoint(routeName, new Waypoint(4, "BIRGU", 45.9467, 26.0217, 10200));
        RouteManager.addWaypoint(routeName, new Waypoint(5, "LROP", 44.5711, 26.0858, 106));


    }
}
