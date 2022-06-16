package leetCode;

public class RotatedArray {
    public static boolean search(int[] nums, int target) {
        int left=0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid +1;
                }
            }else if (nums[mid] < nums[left]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }else{
                left++;// move a step ahead. cause  there is no gaurantee the target will show on which part. cause the shap of first part[left, mid] is not decided.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A= {1,0,1,1,1};
        int t = 0;
        System.out.println(search(A, t));
    }
}
