package scaler.DSA;

import java.util.Arrays;
import java.util.Stack;

public class SortUsingStack {
    public static int[] solve(int[] A) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i = 0; i< A.length; i++){
            if(stack1.isEmpty()) {
                stack1.push(A[i]);
                continue;
            }
            while (!stack1.isEmpty() && A[i] < stack1.peek()){
                int val = stack1.peek();
                stack2.push(val);
                stack1.pop();
            }
            stack1.push(A[i]);
            while(!stack2.isEmpty()){
                int val = stack2.peek();
                stack1.push(val);
                stack2.pop();
            }
        }
        int count = A.length - 1;
        while (!stack1.isEmpty()){
            A[count] = stack1.peek();
            stack1.pop();
            count--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(Arrays.toString(solve(A)));
    }
}
