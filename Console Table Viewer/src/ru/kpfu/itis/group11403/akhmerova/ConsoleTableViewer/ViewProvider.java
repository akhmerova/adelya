package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

/**
 * Created by Adelya on 22.03.2015.
 */
public interface ViewProvider<T> {

    String getLabel(Student student, int a);

    int getColumnCount();

    String[] getHeader();

}