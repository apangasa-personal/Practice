package scaler.DSA;

import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static int[] dNums(int[] A, int B) {
        int[] result = new int[A.length - B + 1];
        HashMap<Integer, Integer> elements = new HashMap<>();
        for(int i = 0; i <B; i++){
            if(elements.containsKey(A[i]))
                elements.put(A[i], elements.get(A[i])+1);
            else
                elements.put(A[i], 1);
        }
        result[0] = elements.keySet().size();
        for(int i = B, j=1; i < A.length ; i++, j++){
            if(elements.containsKey(A[i]))
                elements.put(A[i], elements.get(A[i])+1);
            else
                elements.put(A[i], 1);
            elements.put(A[i-B], elements.get(A[i-B])-1);
            if(elements.get(A[i-B]) == 0)
                elements.remove(A[i-B]);
            result[j] = elements.keySet().size();;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        System.out.println(Arrays.toString(dNums(A, B)));
    }

}
