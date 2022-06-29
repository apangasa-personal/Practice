package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {
    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        if(a == 0) {
            result.add(0);
            return result;
        }
        if(a == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> previous = grayCode(a-1);
        for(int value: previous){
            result.add(value);
        }
        for(int i = previous.size() - 1; i>=0; i--){
            result.add(previous.get(i) ^(1<<(a-1)));
        }
        return result;
    }

    public static void main(String[] rags){
        System.out.println(Arrays.toString(grayCode(2).toArray()));
        grayCode(2);

    }
}
