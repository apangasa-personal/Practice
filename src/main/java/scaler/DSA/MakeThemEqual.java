package scaler.DSA;

public class MakeThemEqual {

    public static int solve(int[] A){
        int smallest = A[0], largest = A[0], steps = 0;
        for(int i = 1; i< A.length; i++) {
            smallest = Math.min(smallest, A[i]);
            largest = Math.max(largest, A[i]);
        }
        while (smallest != largest){
            largest = smallest;
            for(int i = 0; i< A.length; i++){
                if(A[i] != smallest) {
                    A[i] = A[i] / 2;
                    steps++;
                }
                smallest = Math.min(smallest, A[i]);
                largest = Math.max(largest, A[i]);
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] A = {3,1,1,3};
        System.out.println(solve(A));
    }
}
