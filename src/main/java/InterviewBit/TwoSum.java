package InterviewBit;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(final int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int first = -1, second = -1;
        int index1 = -1, index2 = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            if(map.keySet().contains(B - A[i])){
                first = A[i];
                second = B - A[i];
                if( first >= second) {
                    continue;
                }
                break;
            }
        }

        if(first == -1)
            return new int[]{index1, index2};
        for(int i = 0; i < A.length; i++){
            if(first == A[i])
                index1 = first;
            if(second == A[i])
                index2 = second;
        }
        return new int[]{index1, index2};
    }

    public static void main(String[] args) {
        int[] A = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int B = -3;
        twoSum(A, B);
    }
}
