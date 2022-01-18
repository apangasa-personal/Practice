package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSortedArrays {
    public static int[] intersect(final int[] A, final int[] B) {
        int startA = 0, startB = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (startA < A.length && startB < B.length){
            if(A[startA] == B[startB]) {
                result.add(A[startA]);
                startA++; startB++;
            }
            else if(A[startA] < B[startB])
                startA++;
            else
                startB++;
        }
        return result.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1 ,2 ,3 ,3 ,4 ,5 ,6}, B={3 ,3 ,5};
        System.out.println(Arrays.toString(intersect(A,B)));
    }

}
