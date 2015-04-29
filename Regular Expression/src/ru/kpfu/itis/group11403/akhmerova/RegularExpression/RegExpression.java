package ru.kpfu.itis.group11403.akhmerova.RegularExpression;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.*;

/**
 * Created by Adelya on 17.04.2015.
 */

public class RegExpression {
    String exampleName = "[A-Za-z_0-9]+";
    String someServer = "[a-z0-9]+";
    //String ss = "com|ru|org";
    String ss = "[a-z]{2,3}";
    Pattern email = Pattern.compile("([A-Za-z_0-9]+)@([a-z_0-9]+)\\.([a-z]{2,3})");

    public void findEmails(File file) throws IOException {
        Scanner s1 = new Scanner(file);
        StringTokenizer str;
        FileWriter f1 = new FileWriter("Output.txt"); // Результаты будут выводиться в выходной файл Output.txt :

        while (s1.hasNextLine()) {
            str = new StringTokenizer(s1.nextLine());
            while (str.hasMoreTokens()) {

                String z = str.nextToken();
                System.out.println(z);
                if (email.matcher(z).matches()) {
                    f1.write(z);
                    f1.write("\n");
                }
            }
        }
        f1.close();
    }
}

