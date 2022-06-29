package scaler.DSA;

public class Divisorgame {
    public static int gcd(int A, int B) {
        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }
        if(A == 0)
            return B;
        while( A > 0){
            int temp = A;
            A = (B-A)%A;
            B = temp;
        }
        return B;
    }

    public static int solve(int A, int B, int C) {
        int result = 0;
        int num = gcd(B,C);
        num = (B*C)/num;
        int count = 1;
        for(; num<= A; count = count + 1, num = num*count/(count-1)){
            if(A % num == 0)
                result++;
        }
        return result;
    }
    public static void main(String[] args){
        int A = 81991 , B = 2549 , C = 7;
        System.out.println(solve(A,B,C));
    }
}
