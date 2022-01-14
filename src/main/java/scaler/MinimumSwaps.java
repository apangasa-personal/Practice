package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwaps {
    public static int solve(int[] A, int B) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int a = 0; a<A.length; a++) {
            if (A[a] < B)
                indexes.add(a);
        }
//        0 = {Integer@777} 6
//        1 = {Integer@778} 8
//        2 = {Integer@779} 9
//        3 = {Integer@780} 13
//        4 = {Integer@781} 15
//        5 = {Integer@782} 25
//        6 = {Integer@783} 39
//        7 = {Integer@784} 40
//        8 = {Integer@785} 42
//        9 = {Integer@786} 54
//        10 = {Integer@787} 55
//        11 = {Integer@788} 58
//        12 = {Integer@789} 63
//        13 = {Integer@790} 66
//        14 = {Integer@791} 75
//        15 = {Integer@792} 79
//        16 = {Integer@793} 83
        int i = 0, j = 1, result = Integer.MAX_VALUE;
        while(j< indexes.size()){
            if(indexes.get(j) - indexes.get(i) <indexes.size()){
                int value = indexes.size() - j + i - 1;
                result = Math.min(result, value);
                j++;
            }
            else
                i++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {31, 98, 58, 86, 36, 31, 3, 22, 4, 17, 51, 33, 56, 7, 91, 17, 59, 66, 54, 67, 55, 41, 58, 24, 100, 1, 98, 68, 21, 33, 27, 67, 20, 66, 20, 100, 36, 89, 20, 15, 13, 26, 11, 29, 99, 36, 39, 49, 74, 77, 54, 66, 30, 21, 14, 18, 83, 72, 10, 22, 53, 83, 60, 9, 68, 56, 9, 21, 77, 44, 45, 61, 97, 82, 35, 16, 38, 95, 55, 11, 46, 77, 25, 3, 44};
        System.out.println(solve(a,19));
    }
}
