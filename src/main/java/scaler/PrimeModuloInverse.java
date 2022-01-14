package scaler;

public class PrimeModuloInverse {

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
        long res =powCalc(A, B-2, B);
        if(res < 0)
            res = (res + (long)B)%B;

        return (int)res%B;
    }

    public static void main(String[] ags){
        int A = 10, B = 3;
        System.out.println(solve(A,B));
    }


}
