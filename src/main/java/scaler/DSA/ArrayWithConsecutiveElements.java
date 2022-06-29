package scaler.DSA;

public class ArrayWithConsecutiveElements {
    public static int solve(int[] A) {
        for(int i = 0; i< A.length - 1; i++){
            for(int j = i+1; j< A.length; j++){
                if(A[i] > A[j]){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        for(int i = 1; i<A.length; i++)
            if(A[i] != A[i-1] +1)
                return 0;
        return 1;
    }

    public static void main(String[] agrs){
        int[] A = { 1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
