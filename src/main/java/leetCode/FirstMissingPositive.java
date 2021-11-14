package leetCode;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int[] ispresent = new int[nums.length+1];
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] > 0 && nums[i] < ispresent.length)
                ispresent[nums[i]] = 1;
        }
        for(int i = 1; i<ispresent.length; i++) {
            if (ispresent[i] == 0)
                return i;
        }
        return ispresent.length;
    }

    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }
}
