package leetCode;

import java.util.ArrayList;

public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        boolean increasing = true;
        int instanceCount = 0;
        for(int i = 1; i< arr.length;i++){
            if(arr[i] > arr[i-1]){
                if(increasing == false)
                    return false;
            }
            else if(arr[i] < arr[i-1]){
                if(instanceCount == 0){
                    instanceCount = 1;
                    increasing = false;
                }
            }
        }
        if(increasing == true)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(validMountainArray(arr));
    }
}
