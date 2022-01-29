package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Occurrence {
    public static int[] findOccurences(int[] A) {
        TreeMap<Integer, Integer> values = new TreeMap<>();
        for(int i = 0; i < A.length; i++){
            values.put(A[i], values.getOrDefault(A[i], 0) + 1);
        }
        int[] f = new int[values.keySet().size()];
        int c = 0;
        for(Integer keys: values.keySet()){
            f[c] = values.get(keys);
            c++;
        }
        return f;
    }

    public static void main(String[] args) {
        int[] A = {56, 35, 25, 32, 41, 50, 7, 52, 34, 41, 72, 12, 93, 50, 19, 94, 13, 19};
        System.out.println(findOccurences(A));
    }
}
