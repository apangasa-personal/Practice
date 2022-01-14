package scaler;

public class ContainerWithMostWater {
    public static int maxArea(int[] A) {
        if(A.length == 1)
            return 0;
        int start = 0, end = A.length - 1, area = 0;
        while (start <end){
            int tempArea = Math.min(A[start], A[end]) * (end - start);
            area = Math.max(area, tempArea);
            if(A[start] == A[end]){
                if(A[end-1] > A[start+1])
                    end--;
                else
                    start++;
            }
            else if(A[start] > A[end])
                end--;
            else
                start++;
        }
        return area;
    }

    public static void main(String[] args) {
        int[] A = {1,3, 4, 9, 3};
        System.out.println(maxArea(A));
    }
}
