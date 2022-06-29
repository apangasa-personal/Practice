package scaler.DSA;

public class InsertionSort {
    public static void insertionSort(int[] A){
        for(int i = 1; i< A.length; i++){
            int temp = A[i];
            int j = i-1;
            while(j>=0 && A[j] > temp){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = {7,9,-1,5,0,12,42,3,5};
        insertionSort(A);
        System.out.println("done");
    }
}
