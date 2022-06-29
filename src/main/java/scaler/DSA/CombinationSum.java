package scaler.DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class CombinationSum {

    public static void rec(ArrayList<Integer> A, ArrayList<Integer> ans, int B, int index) {
        if(B == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(B < 0)
            return;

        for(int i = index; i < A.size(); i++){
            ans.add(A.get(i));
            rec(A, ans, B - A.get(i), i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    static HashSet<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        res = new HashSet<>();
        Collections.sort(A);
        rec(A, new ArrayList<>(), B, 0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(ArrayList l : res)
            result.add(l);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {8, 10, 6, 11, 1, 16, 8};
        int B = 28;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            al.add(A[i]);
        combinationSum(al, B);
    }

}
