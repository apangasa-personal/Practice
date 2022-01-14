package scaler;

public class AthMagicalNumber {
    public static int gcd(int a, int b){
        if(a==0)
            return b;
        return  gcd(b%a, a);
    }
    public static int solve(int N, int A, int B) {
        if (A > B) return solve(N, B, A);
        int M = (int) 1e9 + 7;
        if (B % A == 0) return (int) ((1L * A * N) % M);
        long L = A / gcd(A, B) * B;
        long lo = A, hi = lo * N;
        System.out.println(gcd(A, B) + "," + L);
        while (lo < hi) {
            long mi = (hi + lo) / 2;
            long c = mi / A + mi / B - mi / L;
            if (c < N) lo = mi + 1;
            else hi = mi;
        }
        System.out.println("ele is " + lo);
        return (int) (lo % M);
    }

    public static int solve1(int A, int B, int C) {
        int mod = 1000000007;
        int gcd = gcd(Math.min(B,C),Math.max(B,C));
        int lcm = (int)((long)B*C/gcd);
        long finalElement = (long)A * (long)Math.min(B,C), start = Math.min(B,C);
        System.out.println(gcd + "," + lcm);
        while (start < finalElement){
            long mid = (start + finalElement)/2;
            long count = mid/B + mid/C - mid/lcm;
            if(count < A) {
                start = mid + 1;
            }
            else
                finalElement = mid;
        }
        System.out.println("ele is " + start);
        return (int) (start%mod);
    }

    public static void main(String[] args) {
        int A = 14 , B = 10 , C = 12;
        System.out.println(solve(A,B,C));
        System.out.println(solve1(A,B,C));
    }
}
