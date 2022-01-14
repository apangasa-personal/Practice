package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int seated = 0;
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        HashMap<Integer, Integer> dropoffs = new HashMap<>();
        for(int i = 0; i < trips.length; i++){
            Set<Integer> keys = dropoffs.keySet();
            Integer[] array = keys.toArray(new Integer[keys.size()]);
            for(int j = 0; j<array.length; j++){
                if(array[j] <= trips[i][1]) {
                    seated -= dropoffs.get(array[j]);
                    dropoffs.remove(array[j]);
                }
            }
            seated += + trips[i][0];
            if(seated > capacity)
                return false;
            if(dropoffs.containsKey(trips[i][2]))
                dropoffs.put(trips[i][2], trips[i][0] + dropoffs.get(trips[i][2]));
            else
                dropoffs.put(trips[i][2], trips[i][0]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{7,5,6},{6,7,8},{10,1,6}};
        int c = 3;
        System.out.println(carPooling(trips, c));
    }
}
