package scaler;

public class PlayerPassing {
    public static int solve(int A, int B, int[] C) {
        int[] stack = new int[A+1];
        stack[0] = B;
        int current = 0;
        for(int i = 0; i< C.length; i++){
            if(C[i] != 0){
                current++;
                stack[current] = C[i];
            }
            else
                current--;
            if(current < -1)
                current = -1;
        }
        if(current == -1)
            return -1;
        return stack[current];
    }

    public static void main(String[] args) {
        int A = 1 , B = 1;
        int[] C = {2,0,0};
        System.out.println(solve(A,B,C));
    }
}
