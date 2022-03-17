package InterviewBit;

import java.util.Arrays;
import java.util.HashMap;

public class SumZero {

    public SumZero() {
    }

    public static int[] lszero(int[] A) {
        int[] B = new int[A.length];
        B[0] = A[0];
        for(int i = 1; i< A.length; i++)
            B[i] = A[i] + B[i-1];

        int start = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i< A.length; i++){
            int adf = B[i];
            if(map.containsKey(B[i])){
                if(i-map.get(B[i]) > end - start){
                    end = i;
                    start = map.get(B[i]);
                }
            }
            else
                map.put(B[i], i);
        }
        int[] r = new int[end - start];
        return Arrays.copyOfRange(A, start+1, end + 1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -3, 3};
        System.out.println(Arrays.toString(lszero(A)));
    }
}
