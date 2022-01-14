package leetCode;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        while(low < high)
        {
            int mid = (high + low) / 2;
            if (arr[mid] == arr[high])
                high--;

            else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[high];
    }

    public static void main(String[] args) {
        int[] A = {11,13,15,17};
        System.out.println(findMin(A));
    }
}
