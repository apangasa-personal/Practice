package InterviewBit;

import java.util.HashSet;

public class FindDuplicatinArray {
    public static  int repeatedNumber(final int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i< A.length; i++){
            if(hashSet.contains(A[i]))
                return A[i];
            hashSet.add(A[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3 ,4 ,1 ,4 ,1};
        System.out.println(repeatedNumber(a));
    }
}
