package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class add2numbers {

    public static int[] addArrays(int[] A, int[] B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = A.length - 1, j = B.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0){
            result.add((A[i] + B[j] + carry)%10);
            carry = (A[i] + B[j] + carry)/10;
            i--;j--;
        }
        while (i >= 0){
            result.add((A[i] + carry)%10);
            carry = (A[i] + carry)/10;
            i--;
        }
        while (j >= 0){
            result.add((B[j] + carry)%10);
            carry = (B[j] + carry)/10;
            j--;
        }
        if(carry == 1)
            result.add(1);

        int[] resultArrray = new int[result.size()];
        int s = 0;
        for( i = result.size() - 1; i>= 0; i--, s++)
            resultArrray[i] = result.get(s);

        return resultArrray;
    }

    public static void main(String[] args) {
       int[] A = {1, 2, 3}, B = {2, 5, 5};
        System.out.println(Arrays.toString(addArrays(A,B)));
    }
}
