package leetCode;

import java.util.*;

public class MaxSplit {
    public static List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum %2 != 0)
            return new ArrayList<>();
        List<Long> stack = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        long l = 0;
        while (finalSum > 0){
            l = l + 2;
            finalSum = finalSum - l;
            if(!set.contains(l) && finalSum > 0){
                stack.add(l);
                set.add(l);
            }
            else{
                stack.remove((Object)(l-2));
                set.remove(l-2);
                stack.add(l);
                set.add(l);
                finalSum = finalSum + l-2;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        int v = 8;
        List<Long> me = maximumEvenSplit(v);
    }
}
