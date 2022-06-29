package scaler.DSA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SumOfMinAndMAx {
    public static int solve(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> mins = new ArrayDeque<>();
        Deque<Integer> maxs = new ArrayDeque<>();
        long sum = 0;
        int mod = 1000000007;
        for(int i = 0; i < k ; i++){
            while (!mins.isEmpty() && arr[i] <= mins.peekLast())
                mins.removeLast();
            while (!maxs.isEmpty() && arr[i] >= maxs.peekLast())
                maxs.removeLast();
            mins.add(arr[i]);
            maxs.add(arr[i]);
        }
        sum = (maxs.peek() + mins.peek() + sum)%mod;
        for (int i = k; i < n; i++) {
            while (!mins.isEmpty() && arr[i] <= mins.peekLast())
                mins.removeLast();
            while (!maxs.isEmpty() && arr[i] >= maxs.peekLast())
                maxs.removeLast();
            if(!maxs.isEmpty() && maxs.peek() == arr[i-k])
                maxs.remove();
            if(!mins.isEmpty() && mins.peek() == arr[i-k])
                mins.remove();
            mins.add(arr[i]);
            maxs.add(arr[i]);
            sum = ((maxs.peek() + mins.peek())%mod + sum)%mod;
        }
        return (int)((mod + (int)sum)%mod);
    }

    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(A, 4));
    }
}
