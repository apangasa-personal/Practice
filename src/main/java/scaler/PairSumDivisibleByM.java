package scaler;

import java.util.HashMap;

public class PairSumDivisibleByM {
    public static int solve(int[] A, int B) {
        int mod = 1000000007;
        HashMap<Integer, Integer> remainder = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(remainder.containsKey(A[i]%B))
                remainder.put(A[i]%B, remainder.get(A[i]%B) + 1);
            else
                remainder.put(A[i]%B, 1);
        }
        long result = 0;
        for(int i = 1; i<= B/2; i++){
            if(i*2 == B)
                continue;
            if(remainder.containsKey(i) && remainder.containsKey(B-i))
                result =(result + ((remainder.get(i)%mod) * (remainder.get(B-i)%mod))%mod)%mod;
        }
        if(remainder.containsKey(0)) {
            int value = remainder.get(0);
            result =(result%mod + (value%mod * (value - 1)%mod)%mod / 2)%mod;
        }
        if(B%2 == 0 && remainder.containsKey(B/2)) {
            int value = remainder.get(B/2);
            result =(result%mod + (value%mod * (value - 1)%mod)%mod / 2)%mod;
        }
        return (int) result;
    }
    public static void main(String[] args){
        int[] A = {93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49};
        int B = 37;
        System.out.println(solve(A,B));
    }
}
