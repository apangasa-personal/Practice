package InterviewBit;

public class LCM {

    public static int gcd(int A, int B){
        if(B == 0)
            return A;
        if(A < B){
            solve(B, A);
        }
        return gcd(B, A%B);
    }
    public static Long solve(int A, int B) {
        Long ALong = new Long(A);
        Long BLong = new Long(B);
        Long result = ALong * BLong;
        int v = gcd(A,B);
        result = result / v;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(4,6));
    }
}
