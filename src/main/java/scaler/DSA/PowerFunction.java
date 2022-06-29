package scaler.DSA;

public class PowerFunction {
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
    public static void main(String[] args){
        int x = -1, n = 1, d = 20;
        System.out.println(powCalc(x,n,d));
    }
}
