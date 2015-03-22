package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

import java.util.Arrays;

/**
 * Created by Adelya on 22.03.2015.
 */
public class ConsoleTableViewer {

    private ModelProvider<Student> model;
    private ViewProvider<Student> view;
    int height;
    Student[] student;

    public ConsoleTableViewer(ModelProvider<Student> model, ViewProvider<Student> view, int height) {
        this.model = model;
        this.view = view;
        this.height = height;
        student = new Student[model.getModel(this.height).length]; // Создает массив из студентов. Размерности введенного числа
        student = model.getModel(this.height); // Присваивает массив getModel новому
        Arrays.sort(student, model.getComparator());
    }

    public void show() {
        for (int i = 0; i < view.getColumnCount(); i++) {
            System.out.printf("%10s", view.getHeader()[i]);
        }
        System.out.println();
        for (int i = 0; i < student.length; i++) {
            System.out.printf("%10s", "Student" + " " + i);
            System.out.printf("%10s", view.getLabel(student[i], 1));
            System.out.printf("%10s", view.getLabel(student[i], 3));
            System.out.printf("%10s", view.getLabel(student[i], 2));
            System.out.println();
        }
    }
}