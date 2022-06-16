package scaler.BackTracking1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NumberOfSquarefulArrays {

    static int result = 0;

    public static boolean isSquareFul(ArrayList<Integer> A){
        for(int i = 1; i < A.size(); i++){
            int v = A.get(i-1) + A.get(i);
            int sqrt = (int)Math.sqrt(v);
            if(sqrt * sqrt != v)
                return false;
        }
        return true;
    }

   public static void solve(ArrayList<Integer> A, int index){
       if(index == A.size()) {
           for(int i = 0; i < A.size(); i++)
               System.out.print(A.get(i) + ",");
           System.out.println();
           result++;
           return;
       }
       HashSet<Integer> swappedElements = new HashSet<>();
       for(int i = index; i < A.size(); i++){
           if(swappedElements.contains(A.get(i)))
               continue;
           swappedElements.add(A.get(i));
           swap(A, index, i);
           if(index != 0){
               int value = A.get(index - 1) + A.get(index);
               int sqrt = (int) Math.sqrt(value);
               if(sqrt * sqrt != value) {
                   swap(A, index, i);
                   continue;
               }
           }
           solve(A, index + 1);
           swap(A, index, i);
       }
       return;
   }

   public static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
   }

    public static int solve(ArrayList<Integer> A) {
        if(A.size() < 2)
            return 0;
        Collections.sort(A);
        solve(A, 0);
        return result;
    }


    public static void main(String[] args) {
        int[] A = {2, 2, 2};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            list.add(A[i]);

        System.out.println(solve(list));
    }
}
