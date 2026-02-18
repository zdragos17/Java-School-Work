package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private Grades grades;

    public Student(int id, String name, Grades grades) {
        this.id = id;
        this.name = name;
        this.grades = new Grades();
    }
    public void addGrade(String materie, int nota){
        grades.addGrade(materie, nota);
    }

    public Map<String, Integer> getGrades() {
        return grades.getGrades();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
