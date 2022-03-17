package scaler;

import java.util.Stack;

public class InfixToPostfix {
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< A.length(); i++){
            if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                sb.append(A.charAt(i));
                if(!stack.isEmpty() && stack.peek() == '^')
                    sb.append(stack.pop());
            }
            else if(A.charAt(i) == ')') {
                while (stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
                if(!stack.isEmpty() && stack.peek() == '^')
                    sb.append(stack.pop());
            }
            else if(A.charAt(i) == '/' || A.charAt(i) == '*'){
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
                    sb.append(stack.pop());
                stack.push(A.charAt(i));
            }
            else if(A.charAt(i) == '-' || A.charAt(i) == '+') {
                while (!stack.isEmpty() && (stack.peek() != '-' || stack.peek() != '+') && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.push(A.charAt(i));
            }
            else
                stack.push(A.charAt(i));
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "r^(k+b^g)/j+(z^a)+i^(g+z)";
        System.out.println(solve(A));
    }
}

//rkbg^+^j/za^+igz+^+
//rkbg^+^j/za^+igz+^+