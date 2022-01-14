package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class BClosestPointsToOrigin {

    public static boolean compare(int[] e1, int[] e2){
        long val1 = (long)(e1[0] * e1[0]) +  e1[1] * e1[1];
        long val2 = (long)(e2[0] * e2[0]) +  e2[1] * e2[1];
        if(val1 > val2)
            return true;
        return false;
    }
    public static int partition(int[][] A, int start, int end){
        int p1 = start+1, p2 = end;
        int[] temp;
        while(p1 <= end){
            if(compare(A[start], A[p1]))
                p1++;
            else if(compare(A[p1], A[start]))
                p2--;
            else {
                temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
            }
        }
        temp = A[start];
        A[start] = A[p1-1];
        A[p1-1] = temp;
        return p1-1;
    }
    public static void quickSort(int[][] A, int start, int end){
        if(start >= end)
            return ;
        int index = partition(A, start, end);
        quickSort(A, start, index - 1);
        quickSort(A,index + 1, end);
    }

    public static int[][] solve(int[][] A, int B) {
        ArrayList<Integer[]> result = new ArrayList<>();
        quickSort(A, 0, A.length - 1);
        return Arrays.copyOfRange(A, 0, B);
    }

    public static void main(String[] args) {
        int[][] A = {{1, 3},{-2, 2}};
        int B = 1;
        int[][] result = solve(A,B);
        System.out.println("done");
    }

}
