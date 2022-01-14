package leetCode;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height.length <2)
            return 0;
        int result = 0;

        for(int i = 0, j = height.length - 1; i<j;){
            if(i == 0 && j == height.length - 1){
                int val = Math.min(height[i], height[j]) * (height.length-1);
                result = Math.max(result,val );
            }
             if (height[i] < height[j]) {
                 i++;
                 int val = Math.min(height[i], height[j]) ;
                 int length = j-i;
                 result = Math.max(result, val * length);
            }
            else {
                j--;
                result = Math.max(result, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,5,25,24,5};
        System.out.println(maxArea(A));
    }
}
