package scaler;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< A.length(); i++){
            if(stack.isEmpty())
                stack.push(A.charAt(i));
            else {
                if(stack.peek() == A.charAt(i))
                    stack.pop();
                else
                    stack.push(A.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.peek());
            stack.pop();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "abccbc";
        System.out.println(solve(A));
    }
}
