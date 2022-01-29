package leetCode;

public class LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxIndex = 0;
        for(int i = 0; i< heights.length; i++){
            if(heights[maxIndex] <= heights[i]){
                maxIndex = i;
            }
        }
        int start = maxIndex, end = maxIndex, left = heights[start], right = heights[end], maxArea = heights[maxIndex];
        while (start > 0 && end < heights.length - 1){
            if(heights[start - 1] > heights[end + 1]){
                start--;
                left = Math.min(left, heights[start]);
                maxArea = Math.max(maxArea, Math.min(left, right) * (end - start + 1));
            }
            else{
                end++;
                right = Math.min(right, heights[end]);
                maxArea = Math.max(maxArea, Math.min(left, right) * (end - start + 1));
            }
        }
        while (start > 0){
            start--;
            left = Math.min(left, heights[start]);
            maxArea = Math.max(maxArea, Math.min(left, right) * (end - start + 1));
        }
        while(end < heights.length - 1){
            end++;
            right = Math.min(right, heights[end]);
            maxArea = Math.max(maxArea, Math.min(left, right) * (end - start + 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] he = {4,2,0,3,2,4,3,4};
        System.out.println(largestRectangleArea(he));
    }
}
