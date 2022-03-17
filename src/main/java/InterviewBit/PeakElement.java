package InterviewBit;

public class PeakElement {

    public static int solve(int[] A) {
        int start = 0, end = A.length - 1;
        while (start <= end){
            int mid = (start + end)/2, s = A[start], e = A[end];
            if(mid == 0|| mid == A.length - 1 || (A[mid] >= A[mid - 1] && A[mid] >= A[mid+1]))
                return A[mid];
            else if(mid > 0 && A[mid - 1] > A[mid]){
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return A[A.length - 1];
    }

    public static void main(String[] args) {
        int[] A = {47, 71, 125, 130, 133, 143, 145, 169, 214, 221, 231, 264, 269, 285, 295, 353, 354, 370, 400, 401, 404, 427, 432, 445, 477, 478, 496, 358, 322, 291, 275, 249, 246, 245, 242, 226, 224, 145, 123, 100, 36, 16};
        System.out.println(solve(A));
    }
}
