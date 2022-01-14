package scaler;

public class CountOfDivisors {
    public static int[] solve(int[] A) {
        int[] result = new int[A.length];
        for(int j = 0; j< A.length; j++){
           for(int i = 1; i*i<= A[j]; i++){
               if(A[j]%i == 0){
                   result[j]++;
                   if(A[j]/i != i)
                       result[j]++;
               }
           }
        }
        return result;
    }

    public static void main(String[] rags){
        int[] A = {8, 9, 10};
        int[] result = solve(A);
        System.out.println("done");
    }
}
