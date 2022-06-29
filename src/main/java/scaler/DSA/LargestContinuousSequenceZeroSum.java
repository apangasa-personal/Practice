package scaler.DSA;

import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public static int[] lszero(int[] A) {
        int[] origArray = Arrays.copyOf(A, A.length);
        for(int i = 1; i<A.length; i++){
            A[i] += A[i-1];
        }
        HashMap<Integer, Integer> elements = new HashMap<>();
        int result = -1, start = 0, end = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i] == 0){
                if(result < i){
                    start = 0;
                    end = i+1;
                    result = end - start;
                }
            }
            else if(elements.containsKey(A[i])){
                if(result < i - elements.get(A[i])){
                    start = elements.get(A[i])+1;
                    end = i+1;
                    result = end - start;
                }
            }
            else
                elements.put(A[i], i);
        }
        if (result == 0 )
            return new int[]{0};
        if(result == -1)
            return new int[]{};
        return Arrays.copyOfRange(origArray, start, end);
    }

    public static void main(String[] args) {
        int[] A = {-19, 8, 2, -8, 19, 5, -2, -23};
        System.out.println(Arrays.toString(lszero(A)));
    }
}
