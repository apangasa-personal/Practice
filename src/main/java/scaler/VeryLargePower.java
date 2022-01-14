package scaler;

public class VeryLargePower {
    public static int powCalc(int A, int B, int C) {
        if(A==0)
            return 0;
        if(B == 0)
            return 1;
        if(B == 1)
            return A;
        long result = powCalc(A, B/2, C);
        if(B%2 == 0)
            return (int) ((result%C * result%C)%C + C)%C;
        else
            return (int) ((result%C * result%C * A%C)%C + C)%C;
    }

    public static int solve(int A, int B) {
        int mod = 1000000006;
        long c = B;
        for(long i = B-1; i>=2; i--)
            c = (c%mod * i%mod)%mod;
        c = (c%mod + mod)%mod;
        int result = powCalc(A,(int)c, mod+1);
        return result;
    }

    public static void main(String[] args){
        int A = 2 , B = 4;
        System.out.println(solve(A,B));
    }
}
