package leetCode;

public class Rotate {
    public static void rotate(int[] nums, int k) {
        if(nums.length < k)
            k = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length - k; i++)
            result[i+k] = nums[i];
        for(int i = nums.length - k, count = 0; i < nums.length; i++, count++)
            result[count] = nums[i];
        for(int i = 0; i< nums.length; i++)
            nums[i] = result[i];
        System.out.println("done");
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int b = 4;
        rotate(a,b);
    }
}
