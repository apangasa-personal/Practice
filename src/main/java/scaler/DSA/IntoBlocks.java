package scaler.DSA;

import java.util.HashMap;

public class IntoBlocks {
    public static int solve(int[] A){
        int left = 1, right = 0, largest = 0;
        int[] count = new int[200000], rightLargest = new int[200000];

        for(int i = 0; i< A.length ; i++){
            count[A[i]]++;
            rightLargest[A[i]] = i;
        }
        long answer = 0;
        for(int i = 0; i<A.length; i++){
            right = Math.max(right, rightLargest[A[i]]);
            largest = Math.max(largest, count[A[i]]);
            if(i==right){
                answer += right - left + 1 -largest;
                left = right + 1;
                largest = right = 0;
            }
        }
        return (int)answer+1;
    }

    public static void main(String[] args) {
        int[] A = {3,7,3,7,3};
        System.out.println(solve(A));
    }
}
