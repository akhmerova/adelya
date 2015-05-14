package ru.kpfu.itis.group11403.akhmerova.BiconnectedComponentsFinder;

/**
 * Created by Adelya on 28.04.2015.
 */

public class Vertex {

    int dfsNum; // у каждой вершины свой порядковый номер посещения в обходе в глубину
    int low; // минимальный номер среди всех вершин, смежных с v и с теми вершинами, в которые мы пришли по пути,
    // проходящем через v.
    int parent; // номер вершины из которой мы попали в текущую вершину
    boolean removed; // посетили

    public Vertex() {
        dfsNum = -1;
        low = -1;
        parent = -1;
        removed = false;
    }
}
