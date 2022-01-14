package leetCode;

public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        int i = -1;
        while(n>0){
            if(i== -1) {
                i = (n & 1);
            }
            else {
                if((i == 1 && ((n&1) == 1)) || (i == 0 && ((n&1) == 0)))
                    return false;
                i = (n & 1);
            }
            n = n>> 1;
        }
        return true;
    }

    public static void  main(String[] rags){
        System.out.println(hasAlternatingBits(5));
    }
}
