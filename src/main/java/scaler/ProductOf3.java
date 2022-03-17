package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOf3 {

    public static int[] buildHeap(int[] a, int size){
        int child = size;
        while (child >= 0){
            int parent = (child - 1)/2;
            if(a[parent] < a[child]){
                swap(a, parent, child);
                child = parent;
            }
            else
                return a;
        }
        return a;
    }

    public static int[] swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
    public static int[] heapSort(int[] A, int size){
        int sizeOfArray = size;
        while (size > -1){
            int parent = 0;
            A = swap(A, 0, size);
            int left = parent * 2 + 1, right = parent * 2 + 2;
            while(left < size){
                int index = left;
                if(right < size && A[left] < A[right])
                    index = right;
                if(A[parent] < A[index])
                    A = swap(A, parent, index);
                parent = index;
                left = parent * 2 + 1;
                right = parent * 2 + 2;
            }
            size--;
        }
        for(int i = 0; i<= sizeOfArray/2; i++)
            A = swap(A, i, sizeOfArray - i);
        return A;
    }

    public static int[] solve(int[] A) {
        int[] r = new int[A.length];

        for(int i = 0; i< A.length; i++ ) {
            A = buildHeap(A, i);
            A = heapSort(A, i);
            if(i < 2){
                r[i] = -1;
            }
            else
                r[i] = A[0] * A[1] * A[2];
        }
        return r;
    }



    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
}
