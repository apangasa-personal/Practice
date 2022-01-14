package scaler;

public class ReversePairs {
    static int count = 0;

    public static void merge(int[] A, int start, int mid, int end){
        int i = start, j = mid + 1;
        while(i <= mid && j <= end){
            if((long)A[i] > (long)(2*(long)A[j])) {
                count = count + mid + 1 - i;
                j++;
            }
            else
                i++;
        }
        i = start;
        j = mid + 1;
        int[] sorted = new int[end - start + 1];
        int k = 0;
        while(i<= mid && j<=end){
            if(A[i] < A[j]){
                sorted[k] = A[i];
                k++;
                i++;
            }
            else{
                sorted[k] = A[j];
                k++;
                j++;
            }
        }
        while(i<= mid){
            sorted[k] = A[i];
            k++;
            i++;
        }
        while(j<=end){
            sorted[k] = A[j];
            k++;
            j++;
        }
        for(i = 0; i< sorted.length; i++, start++){
            A[start] = sorted[i];
        }
    }
    public static void mergeSort(int[] A, int start, int end){
        if(start == end)
            return;
        mergeSort(A, start, (start+end)/2);
        mergeSort(A, (start+end)/2+1, end);
        merge(A, start, (start+end)/2, end);
    }

    public static int solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2000000000, 2000000000, -2000000000};
        System.out.println(solve(A));
    }

}
