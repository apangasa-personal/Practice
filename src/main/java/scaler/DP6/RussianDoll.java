package scaler.DP6;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
    public static class Envelope{
        int height;
        int width;

        public Envelope(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }

    public static class CustomComparator implements Comparator<Envelope>{
        public int compare(Envelope a, Envelope b){
            if(a.height < b.height)
                return -1;
            return 1;
        }
    }

    public static Envelope[] createEnvelopes(int[][] E){
        Envelope[] envelopes = new Envelope[E.length];
        for(int i = 0; i < E.length; i++)
            envelopes[i] = new Envelope(E[i][0], E[i][1]);
        return envelopes;
    }

    public static int solve(int[][] E) {
        Envelope[] envelopes = createEnvelopes(E);
        Arrays.sort(envelopes, new CustomComparator());

        int[] dp = new int[E.length];
        for(int i = 0; i < dp.length; i++)
            dp[i] = -1;

        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[j].height < envelopes[i].height && envelopes[j].width < envelopes[i].width)
                    max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
        }

        int max = 0;
        for(int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);
        return max;
    }

    public static void main(String[] args) {
        int[][] A = {
                {6, 18},
                {2, 14},
                {5, 6},
                {4, 15},
                {8, 11},
                {3, 11},
                {11, 10},
                {5, 11}
                    };
        System.out.println(solve(A));
    }
}
