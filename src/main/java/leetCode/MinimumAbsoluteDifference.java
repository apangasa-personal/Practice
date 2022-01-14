package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        if(arr.length <2)
            return null;
        for(int i = 1; i<arr.length;i++)
            min = Math.min(min, arr[i]-arr[i-1]);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i<arr.length;i++){
            if(arr[i] - arr[i-1] == min)
                result.add(new ArrayList<>(Arrays. asList(arr[i-1], arr[i])));
        }
        return result;
    }

    public static void main(String[] rags){
        int[] a = {4,2,1,3};
        System.out.println(minimumAbsDifference(a));
        System.out.println("done");
    }
}
