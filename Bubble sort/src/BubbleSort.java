import java.util.Arrays;

/**
 * Created by Adelya on 24.02.2015.
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] ar = {20, 2, 4, 1, 13, 15, 56};
        bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
    }


}
