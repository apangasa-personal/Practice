package scaler.DSA;

public class SortedPermutationRankDuplicates2 {

    static long fact(long n) {
        if (n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }

    static int power(long x,int y,int m) {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;
        return (y % 2 == 0) ? p : (int) ((x * p) % m);
    }

    static int modInverse(long a, int m) {
            return power(a, m - 2, m);
    }

    static int lexRank(String s) {
        int mod = 1000003;
        long n = s.length();
        long t_count = 1;
        for (int i = 0; i < n; i++) {
            long less_than = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    less_than += 1;
                }
            }
            long[] d_count = new long[52];
            for (int j = i; j < n; j++) {
                if ((s.charAt(j) >= 'A')
                        && s.charAt(j) <= 'Z')
                    d_count[s.charAt(j) - 'A'] += 1;
                else
                    d_count[s.charAt(j) - 'a' + 26] += 1;
            }
            long d_fac = 1;
            for (long ele : d_count)
                d_fac *= fact(ele);
            d_fac = modInverse(d_fac, mod);
            d_fac = (d_fac + mod)%mod;
            t_count += (fact(n - i - 1) * less_than) * d_fac;
        }
        return (int)t_count%mod;
    }


    public static void main(String[] args)
    {
        String s1 = "abab";
        System.out.print("Rank of " + s1  + " is: " + lexRank(s1) + "\n");

        // Test case 2
        String s2 = "settLe";
        System.out.print("Rank of " + s2 + " is: " + lexRank(s2) + "\n");
    }

}
