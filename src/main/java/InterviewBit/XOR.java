package InterviewBit;

import java.util.HashSet;

public class XOR {

    public static int solve(int[] A, int B) {
        if(B == 0)
            return A.length;
        HashSet<Integer> v = new HashSet<>();
        for(int i = 0; i < A.length; i++)
            v.add(A[i]);
        int r = 0;
        for(int i = 0; i< A.length; i++){
            int lookFor = B ^ A[i];
            if(v.contains(B ^ A[i]))
                r++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A = {3, 6, 8, 10, 15, 50 };
        int B = 5;
        System.out.println(solve(A, B));
    }
}
