package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by Adelya on 22.03.2015.
 */
public class ModelProv implements ModelProvider<Student> {

    public Comparator<Student> getComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGrade() - o2.getGrade() < 0) {
                    return -1;
                } else if
                        (o2.getGrade() - o1.getGrade() > 0) {
                    return 1;
                }
                return 0;
            }
        };
    }

    public String randomName() {
        Random random = new Random();
        String[] name = {"Adelya", "Aliya", "Renata", "Artur", "Ralina", "Maya", "Liya", "Timur", "Leya", "Ariela"};
        return name[random.nextInt(name.length - 1)]; // Выбирает случайное имя
    }

    public Student[] getModel(int a) {
        Student[] student = new Student[a];
        Random random = new Random();
        for (int i = 0; i < a; i++) {
            student[i] = new Student(random.nextInt(100), 1980 + random.nextInt(30),
                    this.randomName());
        }
        return student;
    }
}