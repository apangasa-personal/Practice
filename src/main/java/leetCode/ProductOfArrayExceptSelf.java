package leetCode;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int j = nums.length - 1; j>=0; j--){
            result[j] *= temp;
            temp *= nums[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        A = productExceptSelf(A);
        System.out.println("done");
    }
}
