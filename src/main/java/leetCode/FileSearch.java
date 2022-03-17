package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class FileSearch {
    public static int breakRecords(int A, int[][] B) {
        for(int i = 0; i< B.length; i++){
            if(B[i][0] > B[i][1]){
                int temp = B[i][0];
                B[i][0] = B[i][1];
                B[i][1] = temp;
            }
        }
        Arrays.sort(B, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] <= o2[0])
                    return -1;
                return 1;
            }
        });
        int start = 0;
        for(int i = 1; i< B.length; i++){
            if(B[i][0] <= B[start][1])
                B[start][1] = B[i][1];
            else
                start++;
        }
        for(int i = 0; i< B.length; i++)
            if(B[i][1] == A)
                return i+1;
        return -1;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {{8, 4},
                {3, 1},
                {5, 4},
                {5, 8},
                {3, 4},
                {3, 7},
                {8, 5},
                {5, 8},
                {3, 4}};
        System.out.println(breakRecords(A,B));
    }
}
