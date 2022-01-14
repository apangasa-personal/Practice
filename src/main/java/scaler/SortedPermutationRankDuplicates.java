package scaler;

import java.util.HashMap;

public class SortedPermutationRankDuplicates {
    public static int fact(long n){
        long f=1;
        for(int i=2;i<=n;i++){
            f = (f*i)%1000003;
        }
        return (int)f;
    }
    public static long power(long val, long pow){
        long res=1, mod = 1000003;
        while(pow > 0){
            if((pow&1) > 0)
                res = (res * val)%mod;
            pow>>=1;
            val = (val*val)%mod;
        }
        return res;
    }
    public static int findRank(String A) {
        int n = A.length();
        long mod = 1000003;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            long less_than = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    less_than += 1;
                }
            }
            int[] freq = new int[52];
            for (int j = i; j < n; j++) {
                if(A.charAt(j)>='A' && A.charAt(j)<='Z')
                    freq[A.charAt(j)-'A'] += 1;
                else
                    freq[A.charAt(j) - 'a' + 26] += 1;
            }
            long denominator = 1;
            for (int ele : freq) {
                denominator = (denominator*fact(ele))%mod;
            }

            long inverse = power(denominator,mod-2); // inverse = (1/denominator)%mod

            long permutation = (fact(n-i-1) * inverse) % mod;
            long total_permutation = (less_than * permutation) % mod;
            ans = (ans + total_permutation)%mod;
        }
        return (int)ans;
    }

    public static void main(String[] rags){
        String a = "baa";
        System.out.println(findRank(a));
    }
}
