package ru.kpfu.itis.group11403.akhmerova.Student;

import java.util.Arrays;

/**
 * Created by Adelya on 14.03.2015.
 */
public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student(100, 20, "Artur");
        students[1] = new Student(50, 15, "Maya");
        students[2] = new Student(80, 18, "Adelya");
        Arrays.sort(students, new StudentHelper().compareByName());
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName());
        }
    }
}
