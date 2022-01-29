package scaler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class CompareSortedSubarrays {
    public static long generateHashedValued(int val){
        long rand = (long) (Math.random() * (Integer.MAX_VALUE));
        rand = rand << (int)(Math.random() * (3));
        return rand;
    }

    public static int[] solve(int[] A, int[][] B) {
        int[] result = new int[B.length];
        long[] prefix = new long[A.length];
        HashMap<Integer, Long> values = new HashMap<>();
        for(int i = 0; i< A.length; i++){
            if(!values.containsKey(A[i]))
                values.put(A[i], generateHashedValued(A[i]));
        }
        prefix[0] = values.get(A[0]);
        for(int i = 1; i< A.length; i++){
            prefix[i] = prefix[i-1] + values.get(A[i]);
        }
        for(int i = 0; i< B.length; i++){
            long v1 = prefix[B[i][1]] - (prefix[B[i][0]]) + values.get(A[B[i][0]]);
            long v2 = prefix[B[i][3]] - (prefix[B[i][2]]) + values.get(A[B[i][2]]);
            if(v1 == v2)
                result[i] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0, 555, 1013, 1599, 2051, 2554, 3046, 3595, 4085, 4534, 5044, 5514, 6024, 6529, 7066, 7564, 8099, 8516, 9083, 9516, 10042, 10541, 11010, 11502, 12075, 12576, 13093, 13539, 14044, 14594, 15000, 15549, 16090, 16555, 17081, 17599, 18084, 18588, 19074, 19577, 20094, 20556, 21087, 21511, 22002, 22582, 23025, 23584, 24020, 24511, 25096, 25554, 26003, 26524, 27004, 27501, 28036, 28575, 29017, 29568, 30075, 30541, 31009, 31546, 32067, 32551, 33048, 33577, 34038, 34569, 35067, 35523, 36084, 36508, 37018, 37522, 38048, 38593, 39002, 39538, 40053, 40561, 41011, 41560, 42069, 42562, 43041, 43581, 44039, 44518, 45030, 45503, 46010, 46571, 47047, 47539, 48049, 48518, 49046, 49536, 50045, 50524, 51040, 51570, 52074, 52501, 53058, 53543, 54053, 54539, 55065, 55510, 56070, 56507, 57094, 57561, 58020, 58510, 59003, 59533, 60005, 60566, 61003, 61519, 62003, 62598, 63092, 63581, 64031, 64596, 65075, 65526, 66070, 66590, 67032, 67562, 68085, 68547, 69027, 69533, 70010, 70506, 71001, 71593, 72055, 72555, 73083, 73538, 74032, 74593, 75084, 75554, 76000, 76516, 77045, 77553, 78045, 78519, 79042, 79539, 80086, 80561, 81043, 81527, 82032, 82556, 83068, 83550, 84059, 84558, 85020, 85536, 86033, 86503, 87056, 87551, 88069, 88546, 89015, 89566, 90010, 90528, 91005, 91583, 92034, 92558, 93032, 93596, 94081, 94583, 95083, 95543, 96065, 96549, 97053, 97576, 98052, 98594, 99060, 99559};
        int[][] B = {{1, 197, 1, 197}};
        System.out.println(Arrays.toString(solve(A,B)));
    }

}
