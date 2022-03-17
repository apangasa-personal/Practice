package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BClosestPoints {
    static class Point{
        int xCoordinate;
        int yCoordinate;
        long distanceToOrigin;

        public Point(int[] coordinate) {
            this.xCoordinate = coordinate[0];
            this.yCoordinate = coordinate[1];
            this.distanceToOrigin = (xCoordinate * xCoordinate + yCoordinate * yCoordinate);
        }

        public int[] getCoordiate(){
            return new int[]{this.xCoordinate, this.yCoordinate};
        }
    }


    static class PointDistanceToOriginComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return (int) (a.distanceToOrigin - b.distanceToOrigin);
        }
    }

    public static int[][] solve(int[][] A, int B) {
        PriorityQueue<Point> pointsQueue = new PriorityQueue<>(new PointDistanceToOriginComparator());
        for(int i = 0; i < A.length; i++){
            Point currentPoint = new Point(A[i]);
            pointsQueue.offer(currentPoint);
        }

        int[][] result = new int[B][];
        for(int i = 0; i< B; i++)
            result[i] = pointsQueue.poll().getCoordiate();

        return result;
    }

    static class Pair {
        long ff;
        int ss;
        public Pair(long c, int d) {
            this.ff = c;
            this.ss = d;
        }
    }
    static class CustomComp implements Comparator < Point > {
        @Override
            public int compare(Point a, Point b) {
                if(a.distanceToOrigin > b.distanceToOrigin)
                    return 1;
                return 0;
            }
    }

//    public static int[][] solveother(int[][] A, int B) {
//        ArrayList< Pair > v = new ArrayList < Pair > ();
//        int n = A.length;
//        for (int i = 0; i < n; ++i) {
//            long x = (long) A[i][0];
//            long y = (long) A[i][1];
//            v.add(new Pair(x * x + y * y, i));
//        }
//        PriorityQueue < Pair > minHeap = new PriorityQueue < Pair > (new CustomComp());
//        for (Pair a: v)
//            minHeap.offer(a);
//        int[][] ans = new int[B][2];
//        // Extract B values
//        for (int i = 0; i < B; i++) {
//            Pair val = minHeap.poll();
//            int[] row = A[val.ss];
//            ans[i] = row;
//        }
//        return ans;

//    }

    public static void main(String[] args) {
        int[][] A = {{-762, 643},
                {693, -1004},
                {-1026, 680},
                {722, -1092},
                {1,1},
                {-875, 630},
                {787, -860},
                {-807, 999},
                {1015, -788},
                {-760, 889},
                {990, -642},
                {-1098, 1044},
                {863, -614},
                {-744, 651},
                {959, -898},
                {-905, 926},
                {808, -725},
                {-730, 809},
                {871, -908},
                {-993, 957},
                {658, -924},
                {-927, 872},
                {735, -821},
                {-1069, 1018},
                {839, -777},
                {-957, 786},
                {853, -942},
                {-865, 955},
                {705, -1072},
                {-717, 940},
                {922, -618},
                {-1013, 802},
                {1065, -884},
                {-638, 1063},
                {654, -882},
                {-722, 718},
                {703, -870},
                {-837, 1059},
                {723, -747},
                {-869, 620},
                {951, -625},
                {-890, 693},
                {1043, -927},
                {-745, 636},
                {976, -951},
                {-1055, 711},
                {658, -867},
                {-1011, 1049},
                {867, -624},
                {-685, 1018},
                {1018, -962},
                {-1070, 885},
                {954, -798},
                {-1005, 1095},
                {-370, 81},
                {156, -484},
                {-286, 228},
                {476, -87},
                {-450, 114},
                {86, -315},
                {-89, 466},
                {383, -447}};
        int[][] result = solve(A, 8);
        System.out.println("done");
    }
}
