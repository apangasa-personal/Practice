package scaler;

public class DifferentBitsSumPairwise {
    public static int countBits(int n){
        int result = 0;
        while(n > 0){
            if((n & 1) == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }
    public static int cntBits(int[] A) {
        long answer  = 0, mod = 1000000007;
        int count;
        for(int i = 0; i< 32; i++){
            count = 0;
            for(int j = 0 ; j< A.length; j++){
                if((A[j] & (1 << i)) != 0)
                    count++;
            }
            answer = (answer%mod + (2*(count%mod * (A.length - count)%mod)%mod)%mod)%mod;
        }
        return (int)answer;
    }

    public static void main(String[] args){
        int[] A = {1, 3, 5};
        System.out.println(cntBits(A));
    }
}
