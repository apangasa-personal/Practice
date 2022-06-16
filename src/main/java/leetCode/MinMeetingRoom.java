package leetCode;

import java.util.*;

public class MinMeetingRoom {
    /**
     * Definition of Interval:
     */
    public static class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
    }

    public static class Solution {
        /**
         * @param intervals: an array of meeting time intervals
         * @return: the minimum number of conference rooms required
         */
        public static int minMeetingRooms(List<Interval> intervals) {
            // Write your code here
            Collections.sort(intervals, new CustomComparatorStart());

            PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(new CustomComparatorEnd());
            priorityQueue.offer(intervals.get(0));
            for (int i = 1; i < intervals.size(); i++) {
                Interval current = priorityQueue.poll();
                if(intervals.get(i).start >= current.end){
                    current.end = intervals.get(i).end;
                    priorityQueue.offer(current);
                }
                else{
                    priorityQueue.offer(current);
                    priorityQueue.offer(intervals.get(i));
                }
            }
            return priorityQueue.size();
        }

        public static class CustomComparatorStart implements Comparator<Interval> {
            public int compare(Interval first, Interval second) {
                return first.start - second.start;
            }
        }

        public static class CustomComparatorEnd implements Comparator<Interval> {
            public int compare(Interval first, Interval second) {
                return first.end - second.end;
            }
        }

        public static void main(String[] args) {
            ArrayList<Interval> gfg = new ArrayList<Interval>();
            gfg.add(new Interval(65,424));
            gfg.add(new Interval(351,507));
            gfg.add(new Interval(314,807));
            gfg.add(new Interval(387,722));
            gfg.add(new Interval(19,797));
            gfg.add(new Interval(259,722));
            gfg.add(new Interval(165,221));
            gfg.add(new Interval(136,897));
            System.out.println(minMeetingRooms(gfg));
        }
    }
}
