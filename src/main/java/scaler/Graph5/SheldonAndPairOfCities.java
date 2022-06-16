package scaler.Graph5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SheldonAndPairOfCities {
    public static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int[][] citiesDistances = new int[A+1][A+1];
        for(int i = 0; i < D.length; i++){
            citiesDistances[D[i]][E[i]] = F[i];
            citiesDistances[E[i]][D[i]] = F[i];
        }

        for (int i = 0; i < A+1; i++) {
            for (int j = 0; j < A+1; j++) {
                if (i == j) {
                    citiesDistances[i][j] = 0;
                }
                else if (citiesDistances[i][j] == 0)
                    citiesDistances[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < A+1; k++) {
            for (int i = 0; i < A+1; i++) {
                for (int j = 0; j < A+1; j++) {
                    if (citiesDistances[i][k] < Integer.MAX_VALUE && citiesDistances[k][j] < Integer.MAX_VALUE) {
                        citiesDistances[i][j] = Math.min(citiesDistances[i][j], citiesDistances[i][k] + citiesDistances[k][j]);
                    }
                }
            }
        }
        int[] result = new int[G.length];
        for(int i = 0; i < G.length; i++)
            result[i] = citiesDistances[G[i]][H[i]] == Integer.MAX_VALUE ? -1 : citiesDistances[H[i]][G[i]];
        return result;
    }

    public static void main(String[] args) {
        int A = 15,
        B = 18,
        C = 29;
        int[] D = {11, 2, 2, 6, 2, 8, 9, 3, 14, 15, 4, 14, 8, 7, 8, 6, 2, 12},
              E = { 2, 1, 1, 2, 1, 1, 7, 3,  2, 13, 2,  1, 6, 1, 7, 1, 2, 10},
        F = {8337, 6651, 29, 7765, 3428, 5213, 6431, 2864, 3137, 4024, 8169, 5013, 7375, 3786, 4326, 6415, 8982, 6864 },
        G = {6, 2, 1, 15, 12, 2, 14, 10, 13, 15, 15, 4, 8, 7, 9, 4, 15, 13, 12, 5, 2, 10, 1, 11, 14, 7, 3, 13, 12 },
        H = {5, 2, 15, 13, 6, 2, 8, 6, 3, 13, 15, 3, 1, 1, 4, 4, 5, 8, 1, 3, 1, 10, 15, 9, 2, 1, 1, 10, 2};

        System.out.println(Arrays.toString(solve(A,B,C,D,E,F,G,H)));
    }
}
