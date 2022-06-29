package scaler.DSA;

public class ABandModulo {
    public static int solve(int A, int B) {
        int small = 0, large = 0;
        if(A < B){
            small = A; large = B;
        }
        else {
            small = B; large = A;
        }
        return large - small;
//        int val = large - small;
//        while(val >=1){
//            if(val% == small%val)
//                return val;
//            else
//                val--;
//        }
//        return 1;
    }

    public static void main(String[] args){
        int     A = 9175058,
                B = 3772101,
                C = 5402957;
        System.out.println(solve(A,B));
    }
}
