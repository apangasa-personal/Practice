package scaler.DSA;


import java.util.Arrays;

public class MishaAndCandies {

    public static  int[] swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }

    public static int[] buildHead(int[] A){
        for(int i = A.length/2-1; i >= 0; i--){
            int left = 2 * i + 1;
            int right = left + 1;
            int j = i;
            while(left < A.length){
                int index = left;
                if(right < A.length && A[right] < A[left])
                    index = right;
                if(A[j] > A[index])
                    A = swap(A, index, j);
                else
                    break;
                j = index;
                left = 2 * j + 1;
                right = left + 1;
            }
        }
        return A;
    }

    public static int[] extract(int[] A){
        size--;
        current = A[0];

        if(size < 0)
            return A;

        A = swap(A, 0, size+1);
        int parent = 0, left = 1, right = 2;
        while (left <= size){
            int index = left;
            if(right <= size && A[right] < A[left])
                index = right;
            if(A[index] < A[parent])
                A = swap(A, index, parent);
            else
                return A;
            parent = index;
            left = 2 * parent + 1;
            right = left + 1;
        }
        return A;
    }

    public static int[] insert(int[] A, int value){
        size++;
        int child = size;
        if(size < 0) {
            A[0] = value;
            return A;
        };
        A[size] = value;
        int parent = (child - 1)/2;
        while(A[parent] > A[child] && parent >= 0){
            A = swap(A, parent, child);
            child = parent;
            parent = (child - 1)/2;
        }
        return A;
    }

    static int current = 0;
    static int size = 0;
    public static int solve(int[] A, int B) {
        current = 0; size = A.length - 1;
        A = buildHead(A);
        int result = 0;
        A = extract(A);
        while(current <= B && size >= -1){
            int candiesInCurrentBox = current;
            result = result + candiesInCurrentBox/2;
            A = extract(A);
            int newInsertionValue = current + candiesInCurrentBox - candiesInCurrentBox/2;
            A = insert(A, newInsertionValue);
            A = extract(A);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {705};
        int B = 895;
        System.out.println(solve(A,B));
    }
}
