package scaler.DSA;

import java.util.Stack;

public class MaximumRectangle {

    public static int solve(int[][] A) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0 ; i< A.length; i++){
            stack.clear();
            for(int j = 0; j< A[i].length; j++){
                if(A[i][j] == 1 && i>0) {
                    A[i][j] += A[i - 1][j];
                }
            }
            for(int j = 0; j< A[i].length; j++) {
                if(i == 11 && j == 7)
                    System.out.println("here");
                if(stack.isEmpty() || A[i][stack.peek()] < A[i][j]){
                    stack.push(j);
                }
                else{
                    while (!stack.isEmpty() && A[i][stack.peek()] >= A[i][j]){
                        int value = A[i][stack.peek()];
                        stack.pop();
                        int leftBounday = stack.isEmpty() ? -1 : stack.peek();
                        result = Math.max(result, (j - leftBounday - 1) * value);
                    }
                    stack.push(j);
                }
            }
            if(!stack.isEmpty()){
                int rightBoundary = A[i].length;
                while (!stack.isEmpty()) {
                    int value = A[i][stack.peek()];
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, A[i].length * value);
                    } else {
                        int leftBounday = stack.peek();
                        result = Math.max(result, (rightBoundary - leftBounday - 1) * value);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][]  A = {
                {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1}};
        System.out.println(solve(A));
    }
}
