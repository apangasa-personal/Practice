package scaler.DSA;

import java.util.ArrayList;

public class Sixlets {

    public static void solveCore(ArrayList<Integer> A, ArrayList<Integer> current, int B, int sum, int index) {
        if(current.size() == B){
            if(sum <= 1000)
                result++;
            return;
        }
        for(int i = index; i < A.size(); i++){
            current.add(A.get(i));
            solveCore(A, current, B, sum +  A.get(i), i+1);
            current.remove(A.get(i));
        }
    }

    static int result = 0;
    public static int solve(ArrayList<Integer> A, int B) {
        solveCore(A, new ArrayList<>(), B, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 8};
        int B = 2;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            al.add(A[i]);
        solve(al, B);
    }
}
