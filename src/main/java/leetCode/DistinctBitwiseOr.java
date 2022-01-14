package leetCode;

import java.util.HashSet;

public class DistinctBitwiseOr {
    static int distintBitwiseOR(int arr[], int n) {
        HashSet<Integer> ans = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            int result = arr[i];
            ans.add(result);
            for(int j = i; j<arr.length; j++) {
                result = result | arr[j];
                ans.add(result);
            }
        }
        return ans.size();
    }

    // Driver code
    public static void main (String[] args) {
        int n = 3;
        int arr[] = { 1,11,6,11 };
        System.out.println(distintBitwiseOR(arr, n));

    }

}
