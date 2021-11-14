package scaler;

//bit manipulation:print the next smallest and largest numbers with same no of 1 bits
public class SmallerAndLargerWithSameNumberOF1s {
    public static int zeroIndex(int n){
        int i = 0;
        boolean oneFound = false;
        for(; i<= 31; i++){
            if(((n >> i) & 1) == 1)
                oneFound = true;
            if(((n >> i) & 1) == 0 && oneFound)
                break;
        }
        return i;
    }
    public static int larger(int n){
        int zeroIndex = zeroIndex(n);
        int i = 0;
        for(i = zeroIndex - 1; i >=0; i--){
            if(((n >> i) & 1) == 1)
                break;
        }
        n ^= 1 << zeroIndex;
        n ^= 1 << i;
        return n;
    }

    public static int smaller(int n){
        int zeroIndex = zeroIndex(n);
        int i = 0;
        for(i = zeroIndex + 1; i <=31; i++){
            if(((n >> i) & 1) == 1)
                break;
        }
        n ^= 1 << zeroIndex;
        n ^= 1 << i;
        return n;
    }

    public static void main(String[] args){
        int n = 11; //1011, 0111
        System.out.println(larger(n));
        System.out.println(smaller(n));
    }
}
