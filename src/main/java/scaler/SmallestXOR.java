package scaler;

public class SmallestXOR {
    public static int solve(int A, int B) {
        int temp = A, result = A, setBits = 0;
        while (temp > 0){
            if((temp & 1) == 1)
                setBits++;
            temp = temp >> 1;
        }
        if(setBits == B)
            return result;
        else if(setBits > B){
            result = 0;
           for(int i = 31; i>=0 && B>0; i--){
               if(((1<<i) &  A) != 0) {
                   result = result^(1<<i);
                   B--;
               }
           }
        }
        else{
            B = B - setBits;
            for(int i = 0; i < 32 && B>0; i++){
                if(((result >> i) & 1) == 0){
                    result = result ^(1<<i);
                    B--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int A = 11 , B = 1;
        System.out.println(solve(A,B));
    }

}
