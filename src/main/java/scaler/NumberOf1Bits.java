package scaler;

public class NumberOf1Bits {
    public static int numSetBits(int A) {
        int result = 0;
        while(A > 0){
            if((A & 1) == 1)
                result++;
            A = A>> 1;
        }
        return result;
    }

    public static void main(String[] args){
        int A = 11;
        System.out.println(numSetBits(A));
    }
}
