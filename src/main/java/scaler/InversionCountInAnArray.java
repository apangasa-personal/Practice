package scaler;

public class InversionCountInAnArray {
    public static void mergeSort(int[] A, int start, int end){
        if(start >= end)
            return;
        mergeSort(A, start, (start+end)/2);
        mergeSort(A,(start+end)/2 + 1, end);
        merge(A, start, (start+end)/2, end );
    }

    public static void merge(int[] A, int start, int mid, int end){
        int first = start, second = mid+1, k = 0;
        while(first <= mid && second <= end){
            if(A[first] <= A[second]){
                first++;
            }
            else{
                result = result + (mid+1) - (first);
                second++;
            }
        }
        int[] result = new int[end - start + 1];
        first = start;
        second = mid + 1;
        while(first <= mid && second <= end){
            if(A[first] < A[second]){
                result[k] = A[first];
                first++;
            }
            else{
                result[k] = A[second];
                second++;
            }
            k++;
        }
        while(first <= mid){
            result[k] = A[first];
            first++;
            k++;
        }
        while(second <= end){
            result[k] = A[second];
            second++;
            k++;
        }
        for(int i = 0; i<result.length; i++, start++){
            A[start] = result[i];
        }
    }
    static int result = 0;
    public static int solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {28, 18, 44, 49, 41, 14 };
        System.out.println(solve(A));
    }
}
