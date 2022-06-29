package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Subset {

    public static void subsetsCore(ArrayList A, ArrayList<Integer> values, int start) {
        ArrayList current = new ArrayList(values);
        if(start == A.size()){
            result.add(current);
            return ;
        }
        current.add(A.get(start));
        subsetsCore(A, current, start+1);
        current.remove(A.get(start));
        subsetsCore(A, current, start+1);
    }

    public static class CustomComparator implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
            if(a.size() == 0)
                return -1;
            else if(b.size() == 0)
                return 1;
            else {
                int i = 0, j = 0;
                for (; i < a.size() && j < b.size(); i++, j++) {
                    if (a.get(i) < b.get(j))
                        return -1;
                    else if (a.get(i) == b.get(j))
                        continue;
                    else
                        return 1;
                }
                if (i != a.size())
                    return 1;

                else
                    return -1;
            }
        }
    }


    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        result = new ArrayList<>();
        subsetsCore(A, new ArrayList<>(), 0);
        Collections.sort(result, new CustomComparator());
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            v.add(A[i]);
        subsets(v);
    }
}
