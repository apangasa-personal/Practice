package scaler.DSA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Nintegerscontaining {

    public static int[] solve(int A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = -1;
        for(int i = 0; i< A; i++){
            if(i == 0)
                arrayList.add(1);
            else if(i == 1)
                arrayList.add(2);
            else if(i == 2)
                arrayList.add(3);
            else{
                if(i%3 == 0){
                    start++;
                    arrayList.add(arrayList.get(start) * 10 + 1);
                }
                else if(i%3 == 1){
                    arrayList.add(arrayList.get(start) * 10 + 2);
                }
                else
                    arrayList.add(arrayList.get(start) * 10 + 3);
            }
        }
        return  arrayList.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void main(String[] args) {
        int A = 7;
        System.out.println(Arrays.toString(solve(A)));
    }
}

