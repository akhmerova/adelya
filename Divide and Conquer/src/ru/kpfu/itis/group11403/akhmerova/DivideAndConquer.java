package ru.kpfu.itis.group11403.akhmerova;

/**
 * Created by Adelya on 12.02.2015.
 */
public class DivideAndConquer {

    public static double getMax(double num1, double num2) {
        double max;
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2;
        }
        return max;
    }

    public static double getMin(double num1, double num2) {
        double min;
        if (num1 < num2) {
            min = num1;
        } else {
            min = num2;
        }
        return min;
    }

    public static double findMax(double[] array, int beginElement, int endElement) {
        if (beginElement == endElement) {
            return array[beginElement];
        } else {
            //номер элемента в середине - делим массив пополам
            int middleElement = (beginElement + endElement) / 2;
            double maxOfFirstPart = findMax(array, beginElement, middleElement);
            double maxOfSecondPart = findMax(array, middleElement + 1, endElement);
            return getMax(maxOfFirstPart, maxOfSecondPart);
        }
    }

    public static double findMin(double[] array, int a, int b) {
        if (a == b) {
            return array[a];
        } else {
            //переменная разделения массива
            int m = (a + b) / 2;
            double u = findMin(array, a, m);
            double v = findMin(array, m + 1, b);
            return getMin(u, v);
        }
    }

    public static void main(String[] args) {

        double[] ar = {20, 2, 4, 1, 13, 15, 56};
        double max = findMax(ar, 0, ar.length - 1);
        System.out.println(max);
        double min = findMin(ar, 0, ar.length - 1);
        System.out.println(min);
    }
}
