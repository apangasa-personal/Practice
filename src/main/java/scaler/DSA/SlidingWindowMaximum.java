package scaler.DSA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] r = new int[A.length - B + 1];
        for(int i = 0; i< B; i++){
            while (!queue.isEmpty() && queue.peekLast() < A[i])
                queue.removeLast();
            queue.add(A[i]);
        }
        int count = 1;
        r[0] = queue.peekFirst();
        for(int i = B; i< A.length; i++, ++count){
            while (!queue.isEmpty() && queue.peekLast() < A[i])
                queue.removeLast();
            if(!queue.isEmpty() && queue.peekFirst() == A[i-B])
                queue.removeFirst();
            queue.addLast(A[i]);
            r[count] = queue.peekFirst();
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A = { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
        int B = 9;
        System.out.println(Arrays.toString(slidingMaximum(A,B)));
    }
}
