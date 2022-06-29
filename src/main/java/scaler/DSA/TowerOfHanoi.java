package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A, int src, int temp, int dest) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tempAL = new ArrayList<>();
        if(A == 1) {
            ArrayList<Integer> newfield = new ArrayList<>();
            newfield.add(A);newfield.add(src);newfield.add(dest);
            tempAL.add(newfield);
            return tempAL;
        }
        tempAL = towerOfHanoi(A-1, 1,3,2);
        for(ArrayList<Integer> val: tempAL) {
            result.add(val) ;
        }
        ArrayList<Integer> newfield = new ArrayList<>();
        newfield.add(A);newfield.add(src);newfield.add(dest);
        result.add(newfield);
        tempAL = towerOfHanoi(A-1, 2,1,3);
        for(ArrayList<Integer> val: tempAL) {
            result.add(val) ;
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<Integer> newfield = new ArrayList<>();
        return towerOfHanoi(A, 1,2,3);
    }

    public static void main(String[]rags){
        ArrayList<ArrayList<Integer>> result= towerOfHanoi(3);
        System.out.println("done");
    }
}
