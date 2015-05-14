package ru.kpfu.itis.group11403.akhmerova.BiconnectedComponentsFinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Adelya on 28.04.2015.
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BiconnectedComponentsFinder.inputGraph(new File("Input.txt"));
        // Счетчик
        BiconnectedComponentsFinder.dfscounter = 0;
        BiconnectedComponentsFinder.compcounter = 0; // Число двусвязных комонент
        BiconnectedComponentsFinder.numPoints = 0; // Число точек сочленения
        // Список компонент для вывода в консоли
        BiconnectedComponentsFinder.components = new ArrayList<String>();

        BiconnectedComponentsFinder.points = "Articulation Points:";

        // Находим точки сочленения и двусвязные компоненты
        BiconnectedComponentsFinder.findArticulationPoints(BiconnectedComponentsFinder.vertices.get(0));

        System.out.println("Number of Biconnected Components = " + BiconnectedComponentsFinder.compcounter);
        System.out.println("Number of Articulation Points: " + BiconnectedComponentsFinder.numPoints);
        System.out.println(BiconnectedComponentsFinder.points);

        for (String s : BiconnectedComponentsFinder.components) {
            System.out.println(s);
        }
    }
}
