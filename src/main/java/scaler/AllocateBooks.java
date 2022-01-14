package scaler;

public class AllocateBooks {
    public static int books(int[] A, int B) {
        if(B > A.length)
            return -1;
        int totalPages = 0, start = Integer.MIN_VALUE, result = 0;
        for(int i = 0; i< A.length ; i++) {
            totalPages += A[i];
            start = Math.max(A[i], start);
        }
        while(start <= totalPages){
            int mid = (start + totalPages)/2;
            int person = 1, pageCount = 0;
            for(int i = 0; i < A.length; i++){
                pageCount += A[i];
                if(pageCount > mid) {
                    person++;
                    pageCount = A[i];
                }
            }
            if(person <= B) {
                result = mid;
                totalPages = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
        int B = 26;
        System.out.println(books(A, B));
    }
}
