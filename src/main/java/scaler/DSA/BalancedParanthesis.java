package scaler.DSA;

import java.util.Stack;

public class BalancedParanthesis {
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< A.length(); i++){
            switch (A.charAt(i)){
                case '[': stack.push('['); break;
                case '{': stack.push('{'); break;
                case '(': stack.push('('); break;
                case ']': if(stack.isEmpty() || stack.peek() != '[')
                            return 0;
                            else
                                stack.pop();
                            break;
                case '}': if(stack.isEmpty() || stack.peek() != '{')
                                return 0;
                            else
                                stack.pop();
                                break;
                case ')': if(stack.isEmpty() || stack.peek() != '(')
                                return 0;
                            else
                                stack.pop();
                                break;
            }
        }
        if(stack.isEmpty())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "))))))))";
        System.out.println(solve(A));
    }
}
