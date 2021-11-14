package leetCode;

public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        int duplicate = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == nums[i-1])
                count++;
            else{
                duplicate += count - 1;
                count = 0;
            }
        }
        count = 0;
        int[] result = new int[nums.length - duplicate];
        for(int i = 0, j= 0; i< result.length;){
            if(i == 0) {
                result[i] = nums[i];
                i++;j++;
            }
            else{
                if(nums[j] == nums[j-1] && count <1) {
                    result[i] = nums[j];
                    count++;
                    i++;j++;
                }
                else if(nums[j] != nums[j-1]) {
                    result[i] = nums[j];
                    count = 0;
                    i++;
                    j++;
                }
                else{
                    j++;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        removeDuplicates(nums);
    }
}
