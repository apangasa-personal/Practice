package scaler;

import java.util.Arrays;

public class AddOneToNumber {
    public static int[] plusOne(int[] A) {
        int[] result = new int[A.length+1];
        int carry = 0;
        int j = 0;
        result[j] = A[A.length-1] + 1;
        j++;
        for(int i = A.length - 2; i>=0; i--,j++ ){
            if(result[j-1]/10 != 0){
                carry = result[j-1]/10;
                result[j-1] = result[j-1]%10;
            }
            else
                carry = 0;
            result[j] = A[i] + carry;
        }
        carry = result[j-1]/10;
        if(carry!= 0) {
            result[j] = carry;
            result[j-1] = result[j-1]%10;
        }
        int i  = result.length - 1;
        for(;i>=0;i--) {
            if (result[i] == 0)
                continue;
            else
                break;
        }
        int[] finalResult = Arrays.copyOfRange(result, 0, i+1);
        int beg = 0, last = finalResult.length - 1;
        while(beg < last){
            int temp = finalResult[beg];
            finalResult[beg] = finalResult[last];
            finalResult[last] = temp;
            beg++;last--;
        }
        return finalResult;
    }

    public static void main(String[] args){
        int[] A = { 1, 9, 9, 9, 9, 9, 9};
        int[] result = plusOne(A);
        System.out.println("done");
    }
}
