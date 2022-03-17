package InterviewBit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class AliceMonster {
    public static int solve(int A) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= A; i++ )
            queue.add(i);
        int result = -1;
        while (!queue.isEmpty()){
            result = queue.removeLast();
            if(queue.isEmpty())
                return result;
            int temp = queue.removeLast();
            queue.addFirst(temp);
//            queue.add(queue.removeLast());
        }
        return result;
    }

    public static void main(String[] args) {
        int A =407193;
        System.out.println(solve(A));
    }
}
