package scaler.DSA;

public class GreatestCommonDivisor {
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
    
    public static void main(String[] args){
        int A = 1 , B = 0;
        System.out.println(gcd(A,B));
    }
}
