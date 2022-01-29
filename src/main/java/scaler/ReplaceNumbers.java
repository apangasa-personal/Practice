package scaler;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class ReplaceNumbers {

    public static int[] solve(int[]A, int[][] B){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = B.length - 1; i>=0; i--){
            if(!map.containsKey(B[i][1]))
                map.put(B[i][0], B[i][1]);
            else {
                map.put(B[i][0], map.get(B[i][1]));
            }
        }
        for(int i = 0;i< A.length; i++){
            if(map.containsKey(A[i]))
                A[i] = map.get(A[i]);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5,1,3,1};
        int[][] B = {{1,5}, {5,3}};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
