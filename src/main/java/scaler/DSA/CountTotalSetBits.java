package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CountTotalSetBits {
    public static int findMsb(int n){
        int pos = 0;
        while(n > 0){
            pos++;
            n = n>>1;
        }
        return pos-1;
    }

    public static int solve(int A) {
        if(A == 0)
            return 0;
        long answer = 0, mod = 1000000007;
        int msb = findMsb(A);
        int v1 = 1<<(msb-1);

        //value until 2^n-1 where N is the next right bit of msb
        long newVal = (v1%mod * msb%mod)%mod;
        answer = (answer + newVal)%mod;

        //msb set count from 2^n-1 where N is the next right bit of msb till A
        long msbUntilA = A - (1<<msb) + 1;
        answer = (answer + msbUntilA)%mod;

        //calculate for next msb
        answer = (answer + solve(A - (1<<msb)))%mod;
        return (int)((mod+answer)%mod);
    }

    public static void print(int A){
        ArrayList<Integer> values = new ArrayList<>();
        for(int j = 1; j< A+1; j++){
            values.clear();
            int i = j;
            while(i > 0) {
                if ((i & 1) == 1) {
                    values.add(1);
                }
                else
                    values.add(0);
                i = i >> 1;
            }
            values.sort(Comparator.reverseOrder());
            System.out.println(Arrays.toString(values.toArray()));
        }
    }

    public static void main(String[] args){
        int i = 1000000000;
        System.out.println(solve(i));
    }
}
