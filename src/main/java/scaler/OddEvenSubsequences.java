package scaler;

public class OddEvenSubsequences {

    public static int solve(int[] A) {
        int maxLength = 1;
        boolean nextEven = true;
        if(A[0]%2 == 0)
            nextEven = false;
        else
            nextEven = true;
        for(int i = 0; i< A.length; i++){
            if(nextEven == true && A[i]%2 == 0){
                maxLength++;
                nextEven = false;
            }
            else if(nextEven == false && A[i]%2 != 0){
                maxLength++;
                nextEven = true;
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 2, 5, 6};
        System.out.println(solve(a));
    }
}
