package scaler;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public static String simplifyPath(String A) {
        Stack<String> stack =  new Stack<>();
        for(int i = 0; i< A.length(); i++){
            String directoryName = "";
            while (A.charAt(i) == '/')
                i++;
            while (i < A.length() && A.charAt(i) != '/') {
                directoryName += A.charAt(i);
                i++;
            }
            if(directoryName.equals("."))
                continue;
            else if(directoryName.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    continue;
            }
            else
                stack.push(directoryName);
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            result.insert(0, "/" + stack.peek());
            stack.pop();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String A = "/../";
        System.out.println(simplifyPath(A));
    }
}
