package scaler;

import java.util.ArrayList;

public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        ArrayList<Interval> arrayList = new ArrayList<>();
        for(; i < intervals.size(); i++){
            if(intervals.get(i).end < newInterval.start)
                arrayList.add(intervals.get(i));
            else if(intervals.get(i).start > newInterval.end) {
                arrayList.add(newInterval);
                break;
            }
            else{
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        for(; i < intervals.size(); i++) {
            arrayList.add(intervals.get(i));
        }
        if(arrayList.size() == 0 || newInterval.start > arrayList.get(arrayList.size() - 1).end)
            arrayList.add(newInterval);
        return arrayList;
    }

    public static void main(String[] args){
        Interval interval = new Interval(1,5);
        ArrayList<Interval> arrayList = new ArrayList<>();
//        arrayList.add(interval);
//        Interval interval2 = new Interval(6,9);
//        arrayList.add(interval2);
        Interval intervalInsert = new Interval(1,1);
        ArrayList<Interval> arrayListResult = insert(arrayList, intervalInsert);
        System.out.println("done");
    }

}
