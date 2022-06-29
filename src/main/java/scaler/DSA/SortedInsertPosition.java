package scaler.DSA;

import java.util.Arrays;

public class SortedInsertPosition {
    public static int searchInsert(int[] A, int B) {
        int result = 0, left = 0, right = A.length - 1;
        if(B <= A[0])
            return 0;
        if(B > A[A.length - 1])
            return A.length;
        while(left <= right){
            int[] elem = Arrays.copyOfRange(A, left, right + 1);
            if(B < A[left])
                return left;
            else if(B > A[right])
                return right+1;
            int mid = (left + right)/2;
            if(A[mid] == B){
                if(A[mid - 1] < B)
                    return mid;
                else
                    right = mid - 1;
            }
            else if(A[mid] < B) {
                left = mid + 1;
                result = left;
            }
            else{
                right = mid - 1;
                result = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {17, 30, 32, 69, 94, 96, 106, 118, 127, 159, 169, 170, 178, 183, 209, 238, 242, 247, 253, 261, 265, 279, 288, 302, 305, 316, 352, 357, 374, 376, 392, 402, 410, 421, 439, 442, 444, 446, 454, 458, 464, 467, 468, 498, 500, 513, 523, 541, 545, 556, 575, 608, 616, 629, 631, 635, 669, 674, 682, 686, 693, 695, 719, 733, 754, 755, 756, 778, 802, 822, 824, 828, 835, 847, 848, 862, 864, 878, 883, 885, 904, 908, 928, 934};
        int B =104;
        System.out.println(searchInsert(A, B));

    }
}
