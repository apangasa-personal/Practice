package leetCode;

import java.util.Stack;

public class RemoveParenthesis {
    public static String minRemoveToMakeValid(String s) {
        int openingBracketCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(openingBracketCount <= 0)
                    continue;
                if(openingBracketCount > 0)
                    sb.append(s.charAt(i));
                openingBracketCount--;
            }
            else if(s.charAt(i) == '('){
                sb.append(s.charAt(i));
                if(openingBracketCount < 0)
                    openingBracketCount = 0;
                openingBracketCount++;
            }
            else
                sb.append(s.charAt(i));
        }
        int i = sb.length() - 1;
        while(openingBracketCount > 0){
            if(sb.charAt(i) == '('){
                sb.replace(i,i+1, "");
                openingBracketCount--;
            }
            i--;
        }
        return sb.toString();
    }

    public static String minRemoveToMakeValid(String s, char first, char second, int firstCharCount, int secondCharCount) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == first){
                if(secondCharCount > 0) {
                    sb.append(s.charAt(i));
                    secondCharCount--;
                }
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "())()(((";
        minRemoveToMakeValid(s);
    }
}
