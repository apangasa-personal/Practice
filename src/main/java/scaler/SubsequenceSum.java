package scaler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;

public class SubsequenceSum {
    public static int solve(int[] arr, int B) {
        int n = arr.length;
        int opsize = (int)Math.pow(2, n);
        ArrayList<Integer> variables = new ArrayList<>();
        ArrayList<Integer> variables1 = new ArrayList<>();
        int temp = 0;
        for (int counter = 1; counter < opsize; counter++)
        {
            for (int j = 0; j < n; j++)
            {
                if ((counter>>j & 1) != 0)
                    variables.add(arr[j]);
                if (BigInteger.valueOf(counter).testBit(j))
                    variables1.add(arr[j]);
            }
            temp = 0;
            for(int i = 0; i< variables.size(); i++){
                temp += variables.get(i);
            }
            if(temp == B)
                return 1;
            variables.clear();
            variables1.clear();
        }
        return 0;
    }

    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path, int B) {
        /* Number of subsequences is (2**n -1)*/
        int n = arr.length;
        int opsize = (int)Math.pow(2, n);
        ArrayList<Integer> variables = new ArrayList<>();

        for (int counter = 1; counter < opsize; counter++)
        {
            for (int j = 0; j < n; j++)
            {
                if (BigInteger.valueOf(counter).testBit(j))
                    variables.add(arr[j]);
            }
        }
    }

    public static void main(String[] args){
        int[] A={1,20,13,4,5};
        int B=18;
        solve(A, B);
        //System.out.println(solve(A,B));
    }
}
