package scaler.DSA;

import java.util.Stack;

public class MAXandMIN {

    public static int solve(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        for(int i = 0; i< A.length; i++){
            if(stack.isEmpty())
                maxLeft[i] = -1;
            else{
                while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                    stack.pop();
                }
                if(stack.isEmpty())
                    maxLeft[i] = -1;
                else
                    maxLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = A.length - 1; i >= 0; i--){
            if(stack.isEmpty())
                maxRight[i] = A.length;
            else{
                while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                    stack.pop();
                }
                if(stack.isEmpty())
                    maxRight[i] = A.length;
                else
                    maxRight[i] = stack.peek();
            }
            stack.push(i);
        }
        int[] minLeft = new int[A.length];
        int[] minRight = new int[A.length];
        stack.clear();
        for(int i = 0; i< A.length; i++){
            if(stack.isEmpty())
                minLeft[i] = -1;
            else{
                while (!stack.isEmpty() && A[stack.peek()] > A[i]){
                    stack.pop();
                }
                if(stack.isEmpty())
                    minLeft[i] = -1;
                else
                    minLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = A.length - 1; i >= 0; i--){
            if(stack.isEmpty())
                minRight[i] = A.length;
            else{
                while (!stack.isEmpty() && A[stack.peek()] > A[i]){
                    stack.pop();
                }
                if(stack.isEmpty())
                    minRight[i] = A.length;
                else
                    minRight[i] = stack.peek();
            }
            stack.push(i);
        }
        long result = 0;
        for(int i = 0; i< A.length ; i++){
            result += ((i - maxLeft[i]) * (maxRight[i] - i) * A[i]) - ((i - minLeft[i]) * (minRight[i] - i) * A[i]);
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 3, 8};
        System.out.println(solve(A));
    }
}
