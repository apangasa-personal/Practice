package scaler;

public class DivideIntegers {
    public static long divideCore(int A, int B){
        long la = A;
        la = Math.abs(la);
        long lb = B;
        lb = Math.abs(lb);
        if(la<lb)
            return 0;
        int count = 1;
        while(lb<=la){
            lb = lb<<1;
            count++;
        }
        return ((long)1<<(count-2)) | divideCore((int)(la - (lb>>1)), B);
    }

    public static int divide(int A, int B) {
        long result = divideCore(A,B);
        long mul = (long)A*(long)B;
        if(mul < 0)
            result = result * (-1);
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)result;
    }

    public static void main(String[] rags){
        int A = -2147483648 , B = -1;
        System.out.println(divide(A,B));
    }
}
