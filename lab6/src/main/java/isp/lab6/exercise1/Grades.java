package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.Map;

public class Grades {
    private Map<String, Integer> grades = new HashMap<>();

    public void addGrade(String materie, int nota){
        grades.put(materie, nota);
    }
    public int getGrade(String materie){
        return grades.get(materie);
    }
    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grades=" + grades +
                '}';
    }
}
