package scaler.DSA.BackTracking2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class AllUniquePermutations {
    static HashSet<ArrayList<Integer>> finalResult;
    public static void main(String[] args) {
        finalResult = new HashSet<>();
        int[] A = {5,4};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            list.add(A[i]);
        permute(list);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for(ArrayList<Integer> clist : finalResult)
            resultList.add(clist);

        Collections.sort(resultList, new CustomComparator());
        System.out.println("done");
    }

    public static class CustomComparator implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(o1.size() == 0)
                return -1;
            else if(o2.size() == 0)
                return 1;
            else{
                int i = 0, j = 0;
                while (i < o1.size() && j < o2.size()){
                    if(o1.get(i) < o2.get(i))
                        return -1;
                    else if(o1.get(i) > o2.get(i))
                        return 1;
                    else{
                        i++;j++;
                    }
                }
                if(i < o1.size())
                    return 1;
                else
                    return -1;
            }
        }
    }

    public static void permute(ArrayList<Integer> A, int index, ArrayList<Integer> result) {
        if(index == A.size()) {
            finalResult.add(new ArrayList<>(result));
            return;
        }
        HashSet<Integer> numbers = new HashSet<>();
        permute(A, index + 1, result);
        for(int i = index; i < A.size(); i++){
            if(numbers.contains(A.get(i)))
                continue;
            result.add(A.get(i));
            numbers.add(A.get(i));
            permute(A, i + 1, result);
            result.remove(result.size() - 1);
        }
        return;
    }

    public static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> resultSet = new ArrayList<>();
        Collections.sort(A);
        permute(A, 0, resultSet);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        return result;
    }
}
