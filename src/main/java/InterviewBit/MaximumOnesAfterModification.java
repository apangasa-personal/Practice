package InterviewBit;

public class MaximumOnesAfterModification {
    public static int solve(int[] A, int B) {
        int zeroes = 0;
        int l = 0;
        int maxLen = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                zeroes++;

            while (zeroes > B) {
                if (A[l] == 0)
                    zeroes--;
                l++;
            }

            maxLen = Math.max(maxLen, i - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 1, 0, 1, 0, 1, 0, 1};
        int B = 2;
        System.out.println(solve(A,B));
    }
}
