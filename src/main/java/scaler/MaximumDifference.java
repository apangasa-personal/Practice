package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumDifference {
    public static int solve(ArrayList<Integer> A, int B) {
        int sum1 = 0, sum2 = 0;
        if(B > A.size()/2) {
            Collections.sort(A);
            for (int i = A.size() - 1; i >= A.size() - B; i--)
                sum1 += A.get(i);
            for (int i = A.size() - B - 1; i >= 0; i--)
                sum2 += A.get(i);
            return sum1 - sum2;
        }
        else{
            Collections.sort(A, Collections.reverseOrder());
            for (int i = A.size() - 1; i >= A.size() - B; i--)
                sum1 += A.get(i);
            for (int i = A.size() - B - 1; i >= 0; i--)
                sum2 += A.get(i);
            return sum2 - sum1;
        }

    }

    public static void main(String[] args){
        int[] arr = {93, 51, 84, 81, 89, 82, 28, 78, 86, 35, 64, 38, 49, 99, 83};
        int B = 4;
        ArrayList<Integer> array_list = new ArrayList<Integer>();

        // Using add() method to add elements in array_list
        for (int i = 0; i < arr.length; i++)
            array_list.add(arr[i]);
        int result = solve(array_list, B);
        System.out.println(result);

    }


}
