package InterviewBit;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumSumTriplet {

    public static int solve(ArrayList<Integer> A) {
        A.sort(Comparator.reverseOrder());
        int result = 0;
        for(int i = 0; i< 3; i++)
            result += A.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 1, 4, 9};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            list.add(A[i]);
        System.out.println(solve(list));
    }
}
