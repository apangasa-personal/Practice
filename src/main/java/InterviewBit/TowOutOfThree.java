package InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class TowOutOfThree {
    public int[] solve(int[] A, int[] B, int[] C) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i< A.length; i++) {
            a.add(A[i]);
        }
        for(int i = 0; i< B.length; i++)
            b.add(B[i]);
        for(int i = 0; i< C.length; i++)
            c.add(C[i]);
        Object[] values = a.toArray();
        for(int i= 0; i< values.length; i++)
            treeMap.put((Integer) values[i], treeMap.getOrDefault(values[i], 0 ) + 1);
        values = b.toArray();
        for(int i= 0; i< values.length; i++)
            treeMap.put((Integer) values[i], treeMap.getOrDefault(values[i], 0 ) + 1);
        values = c.toArray();
        for(int i= 0; i< values.length; i++)
            treeMap.put((Integer) values[i], treeMap.getOrDefault(values[i], 0 ) + 1);
        ArrayList<Integer> re = new ArrayList<>();
        for(Integer key: treeMap.keySet())
            if(treeMap.get(key) > 1)
                re.add(key);
        return re.stream().mapToInt(Integer::intValue).toArray();
    }
}
