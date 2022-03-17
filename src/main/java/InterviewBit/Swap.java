package InterviewBit;

public class Swap {

    public static  int solve(int A, int B, int C) {
        int bBit = A &  (1 << (B-1));
        bBit =  bBit>> (B-1);
        int cBit = A &  (1 << (C-1));
        cBit = cBit >> (C-1);
        if(bBit == cBit)
            return A;
        A = A ^ (1 << (C-1));
        A = A ^ (1 << (B-1));
        return A;
    }

    public static void main(String[] args) {
        int A = 9,
            B = 1,
            C = 2;
        System.out.println(solve(A,B,C));
    }
}
