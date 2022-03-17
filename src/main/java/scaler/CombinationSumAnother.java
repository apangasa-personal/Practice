package scaler;

import java.util.ArrayList;
import java.util.TreeSet;

public class CombinationSumAnother {

    public static void combinationSumCore(TreeSet<Integer> A, ArrayList<Integer> current, int B, int index) {
       if(B == 0){
           result.add(new ArrayList<>(current));
           return;
       }
       if(B < 0)
           return;

       for(int i = index; i < A.size(); i++){
           current.add((Integer) A.toArray()[i]);
           combinationSumCore(A, current, B - (Integer) A.toArray()[i], i);
           current.remove(current.size() -1);
       }
    }

    static  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int value : A)
            tree.add(value);
        combinationSumCore(tree, new ArrayList<>(), B, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7};
        int B = 7;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            al.add(A[i]);
        combinationSum(al, B);
    }

}
