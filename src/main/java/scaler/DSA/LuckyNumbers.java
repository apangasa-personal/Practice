package scaler.DSA;

public class LuckyNumbers {
    public static boolean isPrime(int A){
        int count = 0;
        for(int i = 2; i*i<= A; i++){
            if(A%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int solve(int A) {
        int[] result = new int[A+1];
        for(int i = 2; i <= A; i++){
           if(isPrime(i)){
               for(int j = i; j <=A; j = j+i){
                       result[j]++;
               }
           }
        }
        int finalResult = 0;
        for(int i = 0; i<result.length; i++)
            if(result[i] == 2)
                finalResult++;
        return finalResult;
    }

    public static void main(String[] aegs){
        int A = 12;
        System.out.println(solve(A));
    }
}
