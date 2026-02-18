package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.Map;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void deleteStudent(Student s) {
        students.remove(s);
    }

    public void updateStudent(int id, String name) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresent(s -> s.setName(name));
    }

    public double averageGrade(Student s) {
        Map<String, Integer> grades = s.getGrades();
        double sum = 0;
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            int grade = entry.getValue();
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayList() {
        for (Student s : students) {
            System.out.println(s);
        }
    }


}
