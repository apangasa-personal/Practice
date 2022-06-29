package scaler.DSA;

import java.util.Arrays;

public class MaximumAndMinimumMagic {

    public static int partition(int[] A, int start, int end){
        int p1 = start+1, p2 = end;
        while(p1 <= p2){
            if(A[start] > A[p1])
                p1++;
            else if(A[start] < A[p2])
                p2--;
            else{
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
            }
        }
        int temp = A[p1-1];
        A[p1-1] = A[start];
        A[start] = temp;
        return p1-1;
    }

    public static void quickSort(int[] A, int start, int end){
        if (start > end)
            return;
        int partition = partition(A, start, end);
        quickSort(A, start, partition-1);
        quickSort(A, partition+1, end);
    }

    public static int[] solve(int[] A) {
            quickSort(A, 0, A.length - 1);
            int[] a1 = new int[A.length/2];
            int[] a2 = new int[A.length/2];
            for(int i = 0; i<A.length; i++){
                if(i%2 == 0){
                    a1[i/2] = A[i];
                }
                else
                    a2[i/2] = A[i];
            }
            int min = 0;
            for(int i = 0, j = 0; i<a1.length; i++, j++){
                min = min + a2[j] - a1[i];
            }
            for(int i = 0; i<A.length; i++){
                if(i < A.length/2){
                    a1[i] = A[i];
                }
                else
                    a2[A.length -1 - i] = A[i];
            }
            int max = 0;
            for(int i = 0, j = a2.length - 1; i<a1.length; i++, j--){
                max = max + a2[j] - a1[i];
            }
            return new int[]{min, max};
    }
    public static void main(String[] args){
        int[] A = {3, 11, -1, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
}
