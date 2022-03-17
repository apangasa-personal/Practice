package InterviewBit;

import java.util.HashMap;

public class Numberofsubarrayswithmroddnumbers {
    public static int solve(int[] a, int m) {
        int count = 0;
        int prefix[] = new int[a.length + 1];
        int odd = 0;

        for (int i = 0; i < a.length; i++)
        {
            prefix[odd]++;
            if ((a[i] & 1) == 1)
                odd++;
            if (odd >= m)
                count += prefix[odd - m];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 3, 4};
        int B = 2;
        System.out.println(solve(A,B));
    }
}
