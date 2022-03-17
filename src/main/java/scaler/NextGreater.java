package scaler;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static int[] nextGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        if(A.length == 0)
            return A;
        if(A.length == 1)
            return new int[]{-1};
        int[] result = new int[A.length];
        for(int i = A.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() < A[i])
                stack.pop();
            if(stack.isEmpty())
                result[i] = -1;
            else
            result[i] = stack.peek();
            stack.push(A[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A= {34, 35, 27, 42, 5, 28, 39, 20, 28};
        System.out.println(Arrays.toString(nextGreater(A)));
    }
}
