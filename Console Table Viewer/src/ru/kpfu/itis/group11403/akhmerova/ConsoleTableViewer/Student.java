package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

/**
 * Created by Adelya on 22.03.2015.
 */
public class Student {

    private int grade;
    private int year;
    private String name;

    public Student(int grade, int year, String name) {
        this.grade = grade;
        this.year = year;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getGrade() {
        return grade;
    }

}