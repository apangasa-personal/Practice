package leetCode;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch (ch) {
                case '(' :
                case '{' :
                case '[' : stack.push(ch); break;
                case ')' : if (stack.peek() == '(')
                    stack.pop() ; break;
                case '}' :  if (stack.peek() == '{')
                    stack.pop() ; break;
                case ']' :   if (stack.peek() == '[')
                    stack.pop() ; break;
            }
        }
        if(stack.size() > 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        isValid(s);
    }
}
