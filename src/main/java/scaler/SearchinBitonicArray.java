package scaler;

import java.util.Random;

public class SearchinBitonicArray {
    public static int solve(int[] A, int B) {
        int pivot = -1, start = 0, end = A.length - 1;
        while (start <= end){
            pivot = (start + end)/2;
            if((pivot > 0 && A[pivot] > A[pivot - 1] ) && (pivot < A.length - 1 && A[pivot] > A[pivot +1] )){
                break;
            }
            else if (A[pivot] < A[pivot + 1])
                start = pivot + 1;
            else
                end = pivot - 1;
        }
        start = 0; end = pivot;
        while (start <= end){
            int mid = (start + end)/2;
            if(A[mid] == B)
                return mid;
            else if(A[mid] > B)
                end = mid - 1;
            else
                start = mid + 1;
        }
        start = pivot+1; end = A.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if(A[mid] == B)
                return mid;
            else if(A[mid] < B)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 20, 50, 40, 10};
        int B = 5;
        System.out.println(solve(A,B));
        int min = 1;
        int max = 3;
        for(int i = 0; i<100; i++){
            int randomNum = (int) (Math.random() * (max - min + 1)) + 1;
            System.out.println("Random Number: "+randomNum);
        }
    }
}
