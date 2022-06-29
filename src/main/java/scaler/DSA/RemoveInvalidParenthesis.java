package scaler.DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParenthesis {

    static ArrayList<String> result = new ArrayList<String>();
    static int max=0;

    public static List<String> removeInvalidParentheses(String expression) {

        dfs(expression, "", 0, 0);
        if(result.size()==0){
            result.add("");
        }

        return result;
    }

    public static void dfs(String left, String right, int countLeft, int maxLeft){
        if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                if(maxLeft > max){
                    max = maxLeft;
                }

                if(maxLeft==max && !result.contains(right)){
                    result.add(right);
                }
            }
            return;
        }

        if(left.charAt(0)=='('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }else if(left.charAt(0)==')'){
            if(countLeft>0){
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
            }

            dfs(left.substring(1), right, countLeft, maxLeft);

        }else{
            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
        }
    }


    public static void main(String[] args){
        String expression = "()())()";
        removeInvalidParentheses(expression);
    }
}
