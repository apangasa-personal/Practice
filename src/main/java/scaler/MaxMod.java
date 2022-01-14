package scaler;

public class MaxMod {
    public static int solve(int[] A) {
        int largest = A[0], larger = A[1];
        if(A.length <2)
            return 0;
        if(A[0] < A[1]){
            larger = A[0];
            largest=A[1];
        }
        else{}
        for(int i = 2; i<A.length; i++){
            if(A[i] > largest){
                larger = largest;
                largest = A[i];
            }
            else if(A[i] > larger && A[i] != largest)
                larger = A[i];
        }
        return larger%largest;
    }

    public static void main(String[] rags){
        int[] A= {1, 2, 3, 3};
        System.out.println(solve(A));
    }

}
