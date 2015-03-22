package ru.kpfu.itis.group11403.akhmerova.ConsoleTableViewer;

import java.util.Scanner;

/**
 * Created by Adelya on 22.03.2015.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of students:");
        ConsoleTableViewer ctv = new ConsoleTableViewer(new ModelProv(), new ViewProv(), scanner.nextInt());
        scanner.close();
        ctv.show();
    }
}