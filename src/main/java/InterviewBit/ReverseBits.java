package InterviewBit;

public class ReverseBits {
    public static long reverse(long a) {
        if(a == 0)
            return a;
        long result = 0, pow = 1;
       for(int i = 0; i < 32; i++){
           result = result << 1;
           if(a%2 == 1){
               result = result + 1;
           }
           a = a/2;
       }
       return result;
    }

    public static void main(String[] args) {
        long n = 3;
        System.out.println(reverse(n));
    }
}
