package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class SwapInO1 {

    public static void arrange(ArrayList<Integer> a) {
        int mod = a.size();
        for(int i = 0; i < a.size(); i++){
            int element = a.get(i);
            int elementOfElement = a.get(a.get(i));
            element = (element) + mod * (elementOfElement % mod);
            a.set(i, element);
        }
        for(int i = 0; i < a.size(); i++)
            a.set(i, a.get(i) / mod);
        return;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 1};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< arr.length; i++)
            list.add(arr[i]);
        arrange(list);
    }

}
