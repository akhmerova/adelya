package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

/**
 * Created by Adelya on 22.03.2015.
 */
public class ViewProv implements ViewProvider {

    public int getColumnCount() {
        return 4;
    }

    public String getLabel(Student student, int a) {
        String label = "";
        switch (a) {
            case 1:
                label = student.getName();
                break;
            case 2:
                label = "" + student.getGrade();
                break;
            case 3:
                label = "" + student.getYear();
                break;
        }
        return label;
    }

    public String[] getHeader() {
        return new String[]{"Student", "Name", "Year", "Grade"};
    }
}