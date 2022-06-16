package scaler.BackTracking2;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets2 {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        subsetsWithDup(A, new ArrayList<Integer>(), 0, result);
        return result;
    }

    public static void subsetsWithDup(ArrayList<Integer> A, ArrayList<Integer> current, int index, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(current));
        if(index == A.size())
            return;
        current.add(A.get(index));
        subsetsWithDup(A, current, index + 1, result);
        current.remove(0);
        if(index > 0 && A.get(index) == A.get(index - 1))
            return;
        subsetsWithDup(A, current, index + 1, result);
        return;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            list.add(A[i]);
        ArrayList<ArrayList<Integer>> result = subsetsWithDup(list);
        System.out.println("done");
    }
}
