package scaler;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateExpression {
    public static int evalRPN(String[] A) {
        if(A.length <= 1) {
            try{
                return Integer.valueOf(A[0]);
            }
            catch (Exception ex){
                return -1;
            }
        }
        Stack<Integer> operands = new Stack<>();
        for(int i = 0; i< A.length; i++){
            if(A[i].length() == 1 && (Character.valueOf(A[i].charAt(0)) == '+' || Character.valueOf(A[i].charAt(0)) == '-' || Character.valueOf(A[i].charAt(0)) == '/' || Character.valueOf(A[i].charAt(0)) == '*')){
                int v2 = operands.pop();
                int v1 = operands.pop();
                switch (A[i]){
                    case "+": v1 = v1 + v2; break;
                    case "*": v1 = v1 * v2; break;
                    case "/": v1 = v1 / v2; break;
                    case "-": v1 = v1 - v2; break;
                }
                operands.push(v1);
            }
            else{
                operands.push(Integer.valueOf(A[i]));
            }

        }
        return operands.pop();
    }

    public static void main(String[] args) {
        String[] A = {"2", "2", "/"};
        System.out.println(evalRPN(A));
    }
}
