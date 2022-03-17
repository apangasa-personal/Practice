package scaler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FinishMaximumJobs {

    public static class CompareWork implements Comparator<Integer[]>{
        public int compare(Integer[] a, Integer[] b){
            if(a[1] < b[1])
                return -1;
            if(a[1] > b[1])
                return 1;
            return 0;
        }
    }

    public static int solve(int[] A, int[] B) {
        PriorityQueue<Integer[]> works = new PriorityQueue<>(new CompareWork());
        for(int i = 0; i < A.length; i++) {
            Integer[] c = new Integer[]{A[i], B[i]};
            works.offer(c);
        }
        int result = 1;
        Integer[] current = works.poll();
        while(works.size() > 0){
            while(works.size() > 0){
                Integer[] next = works.poll();
                if(next[0] < current[1])
                    continue;
                else {
                    current = next;
                    result++;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] A = {1, 5, 7, 1}, B = {7, 8, 8, 8};
        System.out.println(solve(A, B));
    }
}
