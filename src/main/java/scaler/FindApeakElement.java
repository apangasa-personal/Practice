package scaler;

public class FindApeakElement {
    public static int solve(int[] A) {
        if(A.length == 0 )
            return 0;
        if(A.length == 1)
            return A[0];
        if(A[0] > A[1])
            return A[0];
        if(A[A.length - 1] > A[A.length - 2])
            return A[A.length - 1];
        int start = 1, end = A.length - 2;
        while(start <= end){
            int mid = (start + end)/2;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1])
                return A[mid];
            else if(A[mid] < A[mid-1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(solve(A));
    }
}
