package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Grades grades1 = new Grades();
        Student student1=new Student(12,"Dragos", grades1);
        student1.addGrade("ISP",10);
        student1.addGrade("SM",10);
        student1.addGrade("TS",8);
        System.out.println(student1);
        Grades grades2 = new Grades();
        Student student2=new Student(13,"Sebi", grades2);
        student2.addGrade("PA",1);
        student2.addGrade("TS",6);
        student2.addGrade("ASDNToamna",5);
        System.out.println(student2);
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        studentManagement.displayList();

        studentManagement.displayList();
        double grade=studentManagement.averageGrade(student1);
        System.out.println(grade);
        studentManagement.updateStudent(13,"Croco");
        studentManagement.displayList();
    }
}
