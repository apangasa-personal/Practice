package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        list.add(intervals[0]);
        for(int i = 1, j=0; i< intervals.length; i++){
            if(!((intervals[i][0] > list.get(j)[1]) || (intervals[i][1] < list.get(j)[0]))){
                int[] newVal = new int[2];
                newVal[0] = Math.min(list.get(j)[0], intervals[i][0]);
                newVal[1] = Math.max(list.get(j)[1], intervals[i][1]);
                list.remove(j);
                list.add(newVal);
            }
            else{
                list.add(intervals[i]);
                j++;
            }
        }
        intervals = list.toArray(new int[list.size()][]);
        return intervals;
    }

    public static void main(String[] args) {
        int[][] A = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        A= merge(A);
        System.out.println("done");
    }

}
