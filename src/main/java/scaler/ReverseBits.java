package scaler;

public class ReverseBits {
    public static long reverse(long a) {
        int count = 0;
        long answer = 0;
        while(a > 0){
            if((a & 1) == 1){
                int shift = 31 - count;
                long val = (long)1 << shift;
                answer = answer ^ val;
            }
            a = a>>1;
            count++;
        }
        return answer;
    }

    public static void main(String[] args){
        long i = 3;
        System.out.println(reverse(i));
    }
}
