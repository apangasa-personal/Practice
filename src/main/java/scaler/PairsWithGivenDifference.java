package scaler;

import java.util.Arrays;

public class PairsWithGivenDifference {
    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int first = 0, count = 0;
        for(int second = 1; second < A.length;){
            if(A[second] - A[first] == B){
                while(second <A.length - 1 && A[second] == A[second+1]){
                    second++;
                }
                while(first < A.length - 1 && A[first] == A[first+1]){
                    first++;
                }
                count ++;
            }
            if(A[second] - A[first] > B) {
                first++;
                if(first == second)
                    second++;
            }
            else {
                second++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int B = 0;
        System.out.println(solve(A,B));
    }
}
