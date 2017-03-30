package algorithms.sorting;

import java.util.Arrays;

/**
 * Created on 22.02.17.
 */
public class BubbleSort {


    public static int[] getSotedArray(int [] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
