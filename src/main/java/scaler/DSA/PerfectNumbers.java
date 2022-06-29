package scaler.DSA;

import java.util.ArrayDeque;
import java.util.Queue;

public class PerfectNumbers {
    public static String solve(int A) {
        Queue<String> queue = new ArrayDeque<>();
        if(A == 1)
            return "11";
        if (A == 2)
            return "22";
        queue.add("1"); queue.add("2");
        StringBuilder value  =  new StringBuilder();
        while (A > 0){
            value.delete(0, value.length());
            queue.add(queue.peek() + "1");
            queue.add(queue.peek() + "2");
            value.append(queue.peek());
            queue.remove();
            A--;
        }
        String v = value.reverse().toString();
        value.reverse().append(v);
        return value.toString();
    }

    public static void main(String[] args) {
        int a = 4;
        System.out.println(solve(a));
    }
}
