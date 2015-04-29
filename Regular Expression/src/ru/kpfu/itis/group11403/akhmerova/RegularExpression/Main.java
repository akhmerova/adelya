package ru.kpfu.itis.group11403.akhmerova.RegularExpression;

import java.io.File;
import java.io.IOException;

/**
 * Created by Adelya on 17.04.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        RegExpression rg1 = new RegExpression();
        rg1.findEmails(new File("Input.txt"));
    }
}
