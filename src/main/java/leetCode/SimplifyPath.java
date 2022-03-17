package leetCode;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> sb = new Stack<>();
        for(int i = 0; i < path.length(); i++){
           char ch = path.charAt(i);
           if(ch == '/'){
               if(i == 0)
                   sb.push("");
               else{
                   if(i == path.length() - 1 || (i > 0 && path.charAt(i-1) == '/'))
                       continue;
                   else
                       sb.push("");
               }
           }
           else if(ch == '.') {
               if (i >= 0 && path.charAt(i - 1) == '/') {
                   String dots = "";
                   while (i < path.length() && path.charAt(i) == '.') {
                       i++;
                       dots = dots + '.';
                   }
                   if (i == path.length() || path.charAt(i) == '/') {
                       if (dots.length() < 3) {
                           int d = 0;
                           while (dots.length() > d && sb.size() > 0) {
                               sb.pop();
                               d++;
                           }
                       } else
                           sb.push(dots);
                   } else
                       sb.push(sb.pop() + dots);
                   i--;
               }
               else
                   sb.push(sb.pop() + ch);
           }
           else{
               sb.push(sb.pop() + ch);
           }
        }
        String s = "";
        while (sb.size() > 0) {
            if(sb.peek() == "") {
                sb.pop();
                continue;
            }
            s = "/" + sb.pop() + s;
        }
        if(s.length() == 0)
            return "/";
        return s;
    }

    public static void main(String[] args) {
        String path =
                "/hello../world";
        simplifyPath(path);
    }
}
