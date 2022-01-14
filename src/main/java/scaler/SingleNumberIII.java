package scaler;

import java.util.Arrays;

public class SingleNumberIII {
    public static int[] solve(int[] A) {
        int xor = 0;
        for(int i =0; i< A.length; i++)
            xor = xor ^ A[i];

        int pos = 0;
        for(int i = 0; i<32; i++){
            if((xor>>i & 1) != 0){
                pos = i;
                break;
            }
        }
        int[] res = new int[2];
        for(int i = 0; i< A.length; i++){
            if((A[i] >> pos & 1) != 1)
                res[0] = res[0] ^ A[i];
            else
                res[1] = res[1] ^ A[i];
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args){
        int[] A = {186, 256, 102, 377, 186, 377};
        System.out.println(solve(A));
    }
}
