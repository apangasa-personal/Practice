package leetCode;

import java.util.Stack;

public class ll {

    public static class Element{
        int count;
        char ch;

        public Element(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public static String solve(String A, int B) {
        Stack<Element> stack = new Stack<>();
        if(A.length() == 0)
            return "";
        for(int i = 0; i< A.length(); i++){
            if(stack.isEmpty()){
               stack.push(new Element(1, A.charAt(i)));
            }
            else{
                if(stack.peek().ch == A.charAt(i)){
                    stack.push(new Element(stack.peek().count + 1, A.charAt(i)));
                }
            }
            if(stack.peek().count == B){
                while (stack.size() > 0 && stack.peek().count != 0)
                    stack.pop();
            }
        }
        String r = "";
        while(!stack.isEmpty())
            r = stack.pop().ch + r;
        return r;
    }

    public static void main(String[] args) {
       String A = "aabbbaa";
       int B = 3;
        System.out.println(solve(A,B));
    }
}
