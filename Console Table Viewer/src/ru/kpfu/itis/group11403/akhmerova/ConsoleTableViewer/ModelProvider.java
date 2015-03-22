package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

import java.util.Comparator;

/**
 * Created by Adelya on 22.03.2015.
 */
public interface ModelProvider<T> {

    T[] getModel(int a); // Возвращает массив строк

    Comparator<T> getComparator(); // Сравнивает и сортирует строки

}