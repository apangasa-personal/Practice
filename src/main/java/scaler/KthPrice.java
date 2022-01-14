package scaler;

public class KthPrice {
    public static int kthsmallest(final int[] A, int B) {
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE, result = -1;
        for(int i = 0; i< A.length; i++){
            smallest = Math.min(A[i], smallest);
            largest = Math.max(A[i], largest);
        }

        while (smallest <= largest){
            int mid = (smallest + largest)/2, count = 0 , found = -1;
            for(int i = 0; i< A.length; i++){
                if(A[i] <= mid ){
                    count++;
                    if(A[i] == mid)
                        found = 1;
                }
            }
            if(count >= B && found == 1) {
                result = mid;
                largest = mid - 1;
            }
            else if(count < B)
                smallest = mid+1;
            else
                largest = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        int k = 9;
        System.out.println(kthsmallest(a, k));
    }
}
