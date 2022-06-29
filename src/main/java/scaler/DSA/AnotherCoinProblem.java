package scaler.DSA;

public class AnotherCoinProblem {
    public static int solve(int A) {
        int i = 1;
        while ( i*5 <= A){
            i *= 5;
        }
        int residualAmount = A, count = 0;
        while(residualAmount != 0){
            while(residualAmount >= i){
                residualAmount = residualAmount - i;
                count++;
            }
            i /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 9;
        System.out.println(solve(A));
    }
}
