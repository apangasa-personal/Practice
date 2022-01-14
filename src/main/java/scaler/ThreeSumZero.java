package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ThreeSumZero {
    public static boolean isPresent(HashSet<int[]> elements, int i, int j, int k){
        for (int[] e : elements) {
            if(e[0] == i && e[1] == j && e[2] == k)
                return true;
        }
        return false;
    }
    public static int[][] threeSum(int[] A) {
        Arrays.sort(A);
        HashSet<int[]> elements = new HashSet<>();
        for(int i = 0; i< A.length-2; i++){
            int j = i+1, k = A.length - 1;
            while(j< k){
                if(A[i] + A[j] + A[k] == 0 && !isPresent(elements, A[i], A[j], A[k])){
                    int[] current = new int[]{A[i] , A[j] , A[k]};
                    elements.add(current);
                    j++;k--;
                }
                else if (A[i] + A[j] + A[k] > 0){
                    k--;
                }
                else
                    j++;
            }
        }
        int[][] result = new int[elements.size()][3];
        int count = 0;
        for (int[] i : elements) {
            result[count] = i;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
        int[][] resul = threeSum(A);
        System.out.println("done");
    }
}
