package scaler.DSA;

public class PickFromBothSides {
    public static int solve(int[] A, int B) {
        int sumMax = 0;
        for(int i = 0; i < B; i++){
            sumMax = sumMax + A[i];
        }
        int currentSum = sumMax;
        int j = A.length - 1;
        for(int i = B-1; i>=0; i--){
            currentSum = currentSum - A[i] + A[j];
            sumMax = Math.max(currentSum, sumMax);
            j--;
        }
        return sumMax;
    }

    public static void main(String[] args){
        int[] A = {5, -2, 3 , 1, 2};
        System.out.println(solve(A,3));
    }
}
