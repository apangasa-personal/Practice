package scaler.DSA;

public class DistributeCandy {
    public static int candy(int[] A) {
        int[] candies = new int[A.length];
        candies[0] = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1])
                candies[i] = candies[i-1] + 1;
            else
                candies[i] = 1;
        }

        for(int i = A.length - 2; i>= 0; i--){
            if(A[i] > A[i+1] && candies[i] <= candies[i+1])
                candies[i] = candies[i+1] + 1;
        }

        int result = 0;
        for(int i = 0; i < A.length; i++)
            result += candies[i];

        return result;

    }

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        System.out.println(candy(A));
    }
}
