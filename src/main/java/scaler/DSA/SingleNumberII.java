package scaler.DSA;

public class SingleNumberII {
    public static int singleNumber(final int[] A) {
        int[] result = new int[32];
        for(int i = 0; i<A.length; i++){
            for(int num = A[i], index = 0; num>0; num = num>>1, index++){
                if((num & 1) == 1)
                    result[index]++;
            }
        }
        int number = 0, powerOf2 = 1;
        for(int i = 0; i<32; i++){
            number = number + powerOf2*(result[i]%3);
            powerOf2 *= 2;
        }
        return number;
    }
    public static void main(String[] args){
        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        singleNumber(A);
    }
}
