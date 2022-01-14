package scaler;

import java.util.Arrays;

public class AddBinaryStrings {
    public static String addBinary(String A, String B) {
        String result = "";
        int carry = 0;
        int i = A.length() - 1, j = B.length() - 1;
        for(; i>= 0 && j >= 0; i--, j-- ){
            int val1 = A.charAt(i) - 48, val2 = B.charAt(j) - 48;
            result = (val1 ^  val2 ^ carry) + result;
            if((val1 + val2 + carry) > 1)
                carry = 1;
            else
                carry = 0;
        }
        for(; i>= 0; i--){
            int val1 = A.charAt(i) - 48;
            result = (val1 ^ carry) + result;
            if((val1 & carry) == 1)
                carry = 1;
            else
                carry = 0;
        }
        for(; j>= 0; j--){
            int val2 = B.charAt(j) - 48;
            result = (val2 ^ carry) + result;
            if((val2 & carry) == 1)
                carry = 1;
            else
                carry = 0;
        }
        if(carry == 1)
            result = '1' + result;

        return result;
    }
    public static void main(String[] args){
        String a = "1010110111001101101000" , b = "1000011011000000111100110";
        System.out.println(addBinary(a,b));
    }
}
