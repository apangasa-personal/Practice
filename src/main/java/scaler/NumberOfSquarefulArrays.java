package scaler;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfSquarefulArrays {

    public static ArrayList<Integer> swap(ArrayList<Integer> a, int i, int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        return a;
    }

    public static void solveCore(ArrayList<Integer> A, int index) {
        ArrayList<Integer> current = new ArrayList<>(A);
        if(index == A.size()) {
            resultList.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < current.size(); i++){
            current = swap(current, index, i);
            solveCore(current, index+1);
            current = swap(current, index, i);
        }
    }

    static HashSet<ArrayList<Integer>> resultList = new HashSet<>();
    public static int solve(ArrayList<Integer> A) {
        solveCore(A, 0);
        int resultInt = 0;
        for(ArrayList<Integer> ilist : resultList){
            if(ilist.size() != A.size())
                continue;
            boolean squareful = true;
            for(int i = 1; i < ilist.size(); i++){
                long sqrt = (long)Math.sqrt(ilist.get(i) + ilist.get(i-1));
                long num = (long)ilist.get(i) + (long)ilist.get(i-1);
                if(sqrt * sqrt != num) {
                    squareful = false;
                    break;
                }
            }
            if(squareful)
                resultInt++;
        }
        return resultInt;
    }


    public static void main(String[] args) {
        int[] A = {323950831, 617081634, 113102555, 478465683, 352924446, 995310809, 111567227, 760837709, 746915507};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            list.add(A[i]);

        System.out.println(solve(list));
    }
}
