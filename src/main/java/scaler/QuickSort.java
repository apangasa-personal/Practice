package scaler;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] A, int start, int end){
        int p1 = start + 1, p2 = end;
        while(p1 <= p2){
            if(A[start] > A[p1])
                p1++;
            else if(A[start] < A[p2])
                p2--;
            else {
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
        if(start >= end)
            return;
        int partition = partition(A, start, end);
        quickSort(A, start, partition-1);
        quickSort(A,partition+1, end);
    }

    public static int[] solve(int[] A) {
        quickSort(A, 0 , A.length - 1);
        return A;
    }

    public static void main(String[] args) {
        int[] A = {21, 79, 70, 3, 35, 56, 38, 21, 61, 98, 31, 47, 70, 56, 55, 18, 47, 76, 18, 49, 67, 17, 21, 20, 39, 94, 86, 24, 78, 81, 94, 39, 35, 65, 42};
        A = solve(A);
        System.out.println(Arrays.toString(A));
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        int a = 10, b =10;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + "," + b);
    }
}
