package scaler.DSA;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = 0; i<A.length; i++)
            numbers.add(A[i]);
        int c = 0, s = 0;
        for(int i = 0; i<A.length; i++){
            if(numbers.contains(A[i]-1))
                continue;
            else{
                c = 0;
                int num = A[i];
                while(numbers.contains(num)){
                    num = num+1;
                    c++;
                }
                s = Math.max(s,c);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] A= {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }
}
