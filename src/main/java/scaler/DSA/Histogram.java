package scaler.DSA;

import java.util.Stack;

public class Histogram {
    public static int largestRectangleArea(int[] A) {
        if(A.length == 0)
            return 0;
        if(A.length == 1)
            return A[0];
        int result = 0;
        Stack<Integer> leftMin = new Stack<>();
        for(int i = 0; i< A.length; i++){
            if(leftMin.isEmpty() || A[i] >= A[leftMin.peek()]) {
                leftMin.push(i);
            }
            else{
                while (!leftMin.isEmpty() && A[leftMin.peek()] >= A[i]){
                    int value = A[leftMin.peek()];
                    int leftBoundary = -1;
                    leftMin.pop();
                    if(!leftMin.isEmpty())
                        leftBoundary = leftMin.peek();
                    int newval = (i - leftBoundary - 1) * value;
                    result = Math.max(result, newval);
                }
                leftMin.push(i);
            }
        }
        if (!leftMin.isEmpty()){
            int i = A.length;
            while(!leftMin.isEmpty())
            {
                int curr = A[leftMin.pop()];
                if(leftMin.isEmpty())
                    result  = Math.max(result, curr*i);
                else
                    result  = Math.max(result, curr*(i-leftMin.peek()-1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(A));
    }
}
