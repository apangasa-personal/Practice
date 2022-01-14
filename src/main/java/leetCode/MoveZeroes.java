package leetCode;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0, zeroCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeroCount++;
            else{
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }
        while(zeroIndex < nums.length){
            nums[zeroIndex] = 0;
            zeroIndex++;
        }
        System.out.println("done");
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
