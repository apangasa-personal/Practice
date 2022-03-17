package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {
    public static long getHash(int a, int b, int c, int d){
        return (a * 10000000 + b * 100000 + c * 1000 + d * 10);
    }

    public static int[][] fourSum(int[] A, int B) {
        Arrays.sort(A);
        ArrayList<Integer[]> result = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i < A.length - 3; i++){
            for(int j = i+1; j < A.length - 2; j++){
                for(int k = j+1; k< A.length - 1; k++) {
                    int sum3 = A[i] + A[j] + A[k];
                    int start = k + 1, end = A.length - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        if (sum3 + A[mid] == B) {
                            long hash = getHash(A[i], A[j], A[k], A[mid]);
                            if(!set.contains(hash))
                                result.add(new Integer[]{A[i], A[j], A[k], A[mid]});
                            set.add(hash);
                            break;
                        } else if (sum3 + A[mid] > B)
                            end = mid-1;
                        else
                            start = mid+1;
                    }
                }
            }
        }
        int[][] array = new int[result.size()][4];
        for(int i = 0; i< result.size(); i++){
            for (int j = 0; j< result.get(i).length; j++)
                array[i][j] = result.get(i)[j];
        }

        return array;
    }

    public static void main(String[] args) {
        int[] A = {19, 3, 12, 0, -1, -6, 14, 2, 29, 3, 36, -8, -5, 1, 9, 2, 3};
        int[][] result = fourSum(A, 29);
    }
}
