package InterviewBit;

public class CapacityToShipPackagesWithinBDay {
    public static void main(String[] args) {
        int[] A = {3, 4, 17, 8, 8, 7, 8, 9, 13, 11, 10, 4};
        int B = 14;
        int start = Integer.MIN_VALUE, end = 0, result = 0;
        for(int i = 0; i< A.length; i++) {
            end += A[i];
            start = Math.max(start, A[i]);
        }

        while (start <= end){
            int mid = (start + end)/2;
            int days = 1, val = 0;
            for(int i = 0; i<A.length; i++){
                val += A[i];
                if(val > mid){
                    days++;
                    val = A[i];
                }
            }
            if(days <= B) {
                result = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        System.out.println(result);
    }
}
