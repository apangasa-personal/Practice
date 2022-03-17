package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
     static ArrayList<Integer> swap(ArrayList<Integer> A , int i, int j){
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
        return A;
    }

    public static void permute(ArrayList<Integer> A, int start) {
        if(start == A.size() - 1){
            result.add(new ArrayList<>(A));
            return;
        }

        for(int i = start; i < A.size(); i++) {
            A = swap(A, start, i);
            permute(A, start+1);
            A = swap(A, start, i);
        }
    }

    static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        result = new ArrayList<>();
        permute(A, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            al.add(A[i]);
        permute(al);

    }
}
