package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestCoprimeDivisor {
    public static int gcd(int A, int B){
        if(A>B){
            A = A^B;
            B = A^B;
            A = A^B;
        }
        while(A>0){
            int temp = A;
            A = (B-A)%A;
            B = temp;
        }
        return B;
    }
    public static int cpFact(int A, int B) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1; i*i < A; i++){
            if(A%i == 0) {
                factors.add(i);
                factors.add(A / i);
            }
        }
        int result = 0;
        for(int i = 0; i<factors.size(); i++ ){
            if(gcd(factors.get(i), B) == 1)
                result = Math.max(result, factors.get(i));
        }
        return result;
    }

    public static void main(String[] args){
        int A =2 , B = 3;
        System.out.println("args = " + cpFact(A,B));

    }
}
