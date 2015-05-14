package ru.kpfu.itis.group11403.akhmerova.BiconnectedComponentsFinder;

/**
 * Created by Adelya on 28.04.2015.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BiconnectedComponentsFinder {

    static ArrayList<ArrayList<Integer>> edgeList;
    static ArrayList<Vertex> vertices; // список вершин
    static ArrayList<String> components; // список двусвязных компонент
    static HashMap<Vertex, Vertex> artPoints;
    static int[][] adjacencyMatrix; // матрица смежности

    static int numEdges = 0;

    static int dfscounter, compcounter, numPoints;
    static String comp, points;

    // получаем матрицу смежности
    public static void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i <= adjacencyMatrix.length - 1; i++) {
            for (int j = 0; j <= adjacencyMatrix.length - 1; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // считываем граф из текстового файла
    public static void inputGraph(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int numVertices = new Integer(scanner.nextLine()); // считываем кол-во вершин
        numEdges = 0;
        adjacencyMatrix = new int[numVertices][numVertices];

        // ArrayList для вершин
        vertices = new ArrayList<Vertex>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertex());
        }

        // ArrayList для ребер
        edgeList = new ArrayList<ArrayList<Integer>>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            edgeList.add(new ArrayList<Integer>());
        }

        String oneLine;
        int firstVertexNumber;
        int secondVertexNumber;
        StringTokenizer tokenizer;

        while (scanner.hasNextLine()) {
            oneLine = scanner.nextLine();
            tokenizer = new StringTokenizer(oneLine, " ");
            firstVertexNumber = new Integer(tokenizer.nextToken());
            secondVertexNumber = new Integer(tokenizer.nextToken());

            // заполняем матрицу смежности
            adjacencyMatrix[firstVertexNumber][secondVertexNumber] = 1;
            adjacencyMatrix[secondVertexNumber][firstVertexNumber] = 1;

            addEdge(firstVertexNumber, secondVertexNumber);
            addEdge(secondVertexNumber, firstVertexNumber);
        }

        // читаем реальное количество ребер
        int edges = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            edges += edgeList.get(i).size();
        }
        edges /= 2;

        assert (edges * 2 == numEdges);

        System.out.println("Number of Vertices: " + numVertices);
        System.out.println("Number of Edges: " + edges);
        printAdjacencyMatrix();
    }

    // добавление ребра
    private static void addEdge(int n1, int n2) {
        edgeList.get(n1).add(n2);
        numEdges++;
    }

    // находит точки сочленения
    public static void findArticulationPoints(Vertex v) {

        v.dfsNum = ++dfscounter; // у каждой вершины свой порядковый номер посещения в обходе в глубину
        v.low = v.dfsNum; //low - минимальный номер среди всех вершин, смежных с v и с теми вершинами, в которые мы пришли
        // по пути, проходящем через v.

        // depth first search - поиск в глубину
        int vNum = vertices.indexOf(v);
        ArrayList<Integer> vList = edgeList.get(vNum);
        //поиск смежных вершин
        for (int i = 0; i < vList.size(); i++) {
            Vertex x = vertices.get(vList.get(i));

            if (x.dfsNum == -1) {
                x.parent = vNum;
                findArticulationPoints(x);
                v.low = Math.min(v.low, x.low);

                if (x.low >= v.dfsNum) {

                    // для вывода компонент
                    points += "  " + vNum;
                    numPoints++;
                    comp = "Component " + (compcounter + 1) + ": {";

                    // находит двусвязные компоненты
                    biconnectedComponent(v, x);

                    // для вывода компонент
                    comp += "}";
                    components.add(comp);
                    comp = "";
                    compcounter++;
                }
            } else if (v.parent != vList.get(i)) {
                v.low = Math.min(v.low, x.dfsNum);
            }
        }
    }

    // поиск двусвязных компонент графа по точкам сочленения
    private static void biconnectedComponent(Vertex v, Vertex x) {

        int xNum = vertices.indexOf(x); // порядковый номер первой вершины
        if (xNum == vertices.indexOf(v) || x.removed) {
            return;
        }
        ArrayList<Integer> xList = edgeList.get(xNum); // получаем список(массив) номеров вершин с которыми вершина х
        // имеет ребро (смежные вершины для х)

        for (int i = 0; i < xList.size(); i++) {
            int x1 = xList.get(i); // номер i-той смежной вершины
            if (!vertices.get(x1).removed) {
                comp += "{" + xNum + "," + xList.get(i) + "}";
                x.removed = true;
                biconnectedComponent(v, vertices.get(x1));
            }
        }
    }
}
