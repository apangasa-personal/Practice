package scaler;

import java.util.Arrays;
import java.util.Vector;

public class SubarrayOr {
    public static int solve1(int[] A) {
        int current = 0;
        int sum = 0;
        for(int i = 0; i< A.length; i++){
            current = 0;
            for(int j = i; j < A.length; j++){
                current = current | A[j];
                sum = sum + current;
            }

        }
        return sum;
    }

    static int givesum(int A[], int n)
    {
        int i, sum = 0, sum1 = 0, j;
        for (i = 0; i < n; i++) {
            sum1 = 0;
            for (j = i; j < n; j++)
            {
                sum1 = (sum1 | A[j]);
                sum = sum + sum1;
            }
        }
        return sum;
    }

    static int solve (int[] A){
        long M = 1000000007;
        int n = A.length;
        long pow = 1;
        long ans = 0;
        for(int i = 0;  i< 31; i++){
            int[] B = new int[n];
            for(int j = 0; j < n; j++){
                if(checkBit(A[j], i))
                    B[j]= 1;
            }
            int c = countOr(B, n, M);
            ans = (ans + c*pow)%M;
            pow = (pow*2)%M;
        }
        return (int) ans;
    }

    public static int countOr(int[] B, int N, long M){
        long total = ((N%M)*(N+1)%M)%M;
        total = total/2;
        long sum = 0;
        long c = 0;
        for(int i = 0; i < N; i++){
            if(B[i] == 0){
                c++;
            }
            else {
                c = (c*(c+1)/2)%M;
                sum = (sum + c) % M;
                c = 0;
            }
        }
        c = (c*(c+1)/2)%M;
        sum = (sum + c)%M;
        total = (total%M - sum%M)%M;
        total = (total + M)%M;
        return (int)total;
    }

    public static boolean checkBit(int i,int j){
        if(((i >> j) & 1) == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        int[] A = {347148, 221001, 394957, 729925, 276769, 40726, 552988, 29952, 184491, 146773, 418965, 307, 219145, 183037, 178111, 81123, 109199, 683929, 422034, 346291, 11434, 7327, 340473, 316152, 364005, 359269, 170935, 105784, 224044, 22563, 48561, 165781, 9329, 357681, 169473, 175031, 605611, 374501, 6607, 329965, 76068, 836137, 103041, 486817, 195549, 107317, 34399, 56907, 37477, 189690, 36796, 376663, 39721, 177563, 174179, 183646, 217729, 408031, 429122, 631665, 282941, 526797, 262186, 306571, 63613, 57501, 70685, 226381, 1338, 9360, 130360, 20300, 400906, 87823, 180349, 108813, 18181, 119185, 1, 102611, 63591, 12889, 311185, 383896, 8701, 76077, 75481, 386017, 153553, 304913, 383455, 105948, 142885, 1, 12610, 137005, 119185, 16948, 66171, 123683};
//        int[] A = {6, 5, 4, 3, 2};
        System.out.println(givesum(A, A.length));
        System.out.println(solve(A));
    }
}
