package scaler.DSA;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSum {
    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE, absvalue = Integer.MAX_VALUE;
        for(int i = 0; i< A.length - 2; i++ ){
            int start = i+1, end = A.length - 1;
            while (start < end){
                if(Math.abs(A[i] + A[start] + A[end] - B) < absvalue) {
                    ans = A[i] + A[start] + A[end];
                    absvalue = Math.abs(A[i] + A[start] + A[end] - B);
                }
                if(A[i] + A[start] + A[end] > B)
                    end--;
                else
                    start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A= {-1, 2, 1, -4};
        int B = 1;
        System.out.println(threeSumClosest(A, B));
    }
}
