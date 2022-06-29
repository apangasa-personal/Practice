package scaler.DSA;

public class SortByColor {

    public static  int[] sortColors(int[] A) {
        int mid = 0, start = 0, end = A.length - 1;
        while (mid <= end){
            if(A[mid] == 0){
                int temp = A[start];
                A[start] = A[mid];
                A[mid] = temp;
                mid++;
                start++;
            }
            else if(A[mid] == 2){
                int temp = A[end];
                A[end] = A[mid];
                A[mid] = temp;
                end--;
            }
            else
                mid++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {0 ,1 ,2 ,0 ,1, 2};
        A = sortColors(A);
        System.out.println("done");
    }
}
