package scaler;

public class KthSymbol {
    public static int solve(int A, int B) {
        if(A == 1 || B == 1)
            return 0;
        if(B < Math.pow(2,(A-2)))
            return solve(A-1, B);
        else
            return 1-solve(A-1, (int)(B + - Math.pow(2,A-2)));
    }

    public static void main(String[] rags){
        System.out.println(solve(5,5));
    }
}
