package scaler.DSA;

import java.util.Stack;

public class NearestSmallerElement {
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stackClosestMinimum = new Stack<>();
        for(int i = 0; i< A.length; i++){
            if(stackClosestMinimum.isEmpty()){
                stackClosestMinimum.push(A[i]);
                A[i] = -1;
            }
            else{
                while(!stackClosestMinimum.isEmpty() && stackClosestMinimum.peek() > A[i]){
                    stackClosestMinimum.pop();
                }
                if(stackClosestMinimum.isEmpty()){
                    stackClosestMinimum.push(A[i]);
                    A[i] = -1;
                }
                else{
                    int value = stackClosestMinimum.peek();
                    stackClosestMinimum.push(A[i]);
                    A[i] = value;
                }
            }
        }
        return  A;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        System.out.println(prevSmaller(A));
    }
}
