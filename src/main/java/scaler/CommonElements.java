package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElements {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> values = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i< A.length; i++)
            values.put(A[i], values.getOrDefault(A[i], 0) + 1);

        for(int i = 0; i< B.length; i++){
            if(values.containsKey(B[i])){
                arrayList.add(B[i]);
                values.put(B[i], values.get(B[i]) - 1);
                if(values.get(B[i]) == 0)
                    values.remove(B[i]);
            }
        }
        return arrayList.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 10} , B = {3, 6, 2, 10, 10};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
