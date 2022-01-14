package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArray {
    public static void arrange(List<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
            int val1 = A.get(i)% A.size();
            int val2 = A.get(val1)%A.size();
            A.set(i, val2 * A.size() + val1);
        }
        for(int i = 0; i < A.size(); i++) {
            A.set(i, A.get(i) / A.size());
        }
        System.out.println("done");
    }

    public static void main(String[] args){
        Integer[] values = {1,3,0,4,2};
        arrange(Arrays.asList(values));
    }
}
