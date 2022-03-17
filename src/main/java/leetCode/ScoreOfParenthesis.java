package leetCode;

import java.util.Locale;
import java.util.Stack;

public class ScoreOfParenthesis {
    public static int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(s.charAt(i) == ')'){
                if(stack.size() > 0) {
                    result += Math.pow(2, stack.size() - 1);
                    while (stack.size() > 0) {
                        if(i < s.length() && s.charAt(i) == ')')
                            stack.pop();
                        else
                            break;
                        i++;
                    }
                    if(i == s.length())
                        return result;
                    i--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String  s= "()(())()(((()(()())))(((())(()))()))(((())))";
        scoreOfParentheses(s);
    }
}
