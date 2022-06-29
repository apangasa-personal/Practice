package scaler.DSA;

public class Countofpairswiththegivensum {
    public static int solve(int[] A, int B) {
        int start = 0, end = A.length -1, count = 0;
        while(start < end){
            if(A[start] + A[end] == B) {
                count++;
                start++;
                end--;
            }
            else if(A[start] + A[end] > B)
                end--;
            else
                start++;
        }
        return  count;
    }

    public static void main(String[] args) {
        int[]  A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(solve(A,B));
    }
}
