package scaler;

import java.util.Arrays;

public class PairswithgivensumII {
    public static int solve(int[] A, int B) {
        int first = 0, end = A.length - 1, mod = 1000000007;
        long count = 0;
        while (first < end){
            if(A[first] + A[end] == B){
                long firstCount = 1, secondCount = 1;
                while(first < end-1 && A[first] == A[first+1]){
                    firstCount++;
                    first++;
                }
                while(end > first +1 && A[end] == A[end-1]){
                    secondCount++;
                    end--;
                }
                if(A[first] == A[end]){
                    long totalCount = (firstCount%mod +secondCount%mod)%mod;
                    count = (count%mod + (totalCount%mod * (totalCount-1)%mod)%mod/2)%mod;
                }
                else
                    count = (count%mod + (firstCount%mod * secondCount%mod)%mod)%mod;
                first++;
                end--;
            }
            else if(A[first] + A[end] > B)
                end--;
            else
                first++;
        }
        return (int)((count)%mod);
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 4, 4, 5, 6, 7, 10};
        int B =8;
        System.out.println(solve(A,B));
    }
}
