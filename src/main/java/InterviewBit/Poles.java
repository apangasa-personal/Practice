package InterviewBit;

public class Poles {

    public static int solve(int[] A){
        int[] l = new int[A.length];
        for(int i = 2; i< A.length; i++){
            if(A[i] < A[i-1])
                l[i] = i-1;
            else
                l[i] = l[i-1];
        }
        int result = 0;
        for(int i = 1; i < A.length; i++)
            result += i - l[i];
        return result + 1;
    }
    public static void main(String[] args) {
        int[] A = {29,107,130, 105, 51, 96, 36, 79, 120, 55, 22, 113, 60, 32, 8, 127, 52};
       // int[] A = {120, 131, 101, 30, 17, 127};
        System.out.println(solve(A));
    }
}
