package scaler.DSA;

import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> min = new Stack<>();
    public static void push(int x) {
       if(min.isEmpty() || x < min.peek())
           min.push(x);
       else
           min.push(min.peek());
       stack.push(x);
    }

    public static void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            min.pop();
        }
    }

    public static int top() {
        if(stack.isEmpty())
            return -1;
       return stack.peek();
    }

    public static int getMin() {
        if(stack.isEmpty())
            return -1;
        return min.peek();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
       push(-2);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(top());
    }
}
