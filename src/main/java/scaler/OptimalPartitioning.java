package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OptimalPartitioning {
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE, temp = Integer.MAX_VALUE;
        for(int i = 1; i < A.size(); i++){
            temp = A.get(i) - A.get(i-1);
            min  = Math.min(temp, min);
        }
        return min;
    }
    public static void main(String[] arga){
        int[] arr = {2, 1, 3, 2, 4, 3};
        ArrayList<Integer> array_list = new ArrayList<Integer>();

        // Using add() method to add elements in array_list
        for (int i = 0; i < arr.length; i++)
            array_list.add(arr[i]);
        int result = solve(array_list);
        System.out.println(result);
    }

}
