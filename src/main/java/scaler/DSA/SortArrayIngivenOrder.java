package scaler.DSA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class SortArrayIngivenOrder {
    public static int[] solve(int[] A, int[] B) {
        TreeMap<Integer, Integer> ems = new TreeMap<>();
        for(int i = 0; i<A.length; i++){
            if(ems.containsKey(A[i]))
                ems.put(A[i], ems.get(A[i]) + 1);
            else
                ems.put(A[i], 1);
        }
        ArrayList<Integer> finArray = new ArrayList<>();
        for(int i = 0; i<B.length; i++){
            if(ems.containsKey(B[i])){
                int count = ems.get(B[i]);
                while (count > 0){
                    finArray.add(B[i]);
                    count--;
                }
                ems.remove(B[i]);
            }
        }

        for(int i: ems.keySet()){
            int count = ems.get(i);
            while (count > 0){
                finArray.add(i);
                count--;
            }
        }
        return finArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5}, B = {5, 4, 2};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
