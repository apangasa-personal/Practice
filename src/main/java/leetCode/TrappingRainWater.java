package leetCode;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int[] maxfLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxfLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];
        for(int i = 1; i<height.length; i++)
            maxfLeft[i] = Math.max(maxfLeft[i-1], height[i]);
        for(int j = height.length - 2; j>=0; j--)
            maxRight[j] = Math.max(maxRight[j+1], height[j]);
        int result = 0;
        for(int i = 1; i<height.length - 1; i++)
            result += Math.min(maxfLeft[i], maxRight[i]) - height[i];
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
    }
}
