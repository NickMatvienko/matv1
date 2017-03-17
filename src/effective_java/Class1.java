package effective_java;

import java.util.AbstractList;
import java.util.List;

/**
 * Created on 06.03.17.
 */
public class Class1 {

    public static void main(String[] args) {
        int [] a  = {1,2,3,45,6};
        System.out.println(intArrayAsList(a));
    }


    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();
        return new AbstractList<Integer>() {
            public Integer get(int i) {
                return a[i]; // Autoboxing (Item 5)
            }
            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
// Auto-unboxing
                return oldVal; // Autoboxing
            }
            public int size() {
                return a.length;
            }
        };
    }
}
