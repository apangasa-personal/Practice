package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Boolean[] courseCompleted = new Boolean[numCourses+1];
        ArrayList<Integer> results = new ArrayList<>();
        if(prerequisites.length == 0){
            results.add(0);
            return results.stream().mapToInt(i->i).toArray();
        }
        return null;
    }

    public static void main(String[] args){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = findOrder(numCourses, prerequisites);
        System.out.println("done");
    }
}
