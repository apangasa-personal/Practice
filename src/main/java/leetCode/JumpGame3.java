package leetCode;

public class JumpGame3 {

    public static boolean canReach(int[] arr, int start, boolean[] visited) {
        if(start < 0 || start > arr.length - 1 || visited[start] == true)
            return false;

        if(start + arr[start] < arr.length && arr[start + arr[start]] == 0)
            return true;
        if(start - arr[start] > -1 && arr[start - arr[start]] == 0)
            return true;
        visited[start] = true;
        if(canReach(arr, start + arr[start], visited) == true)
            return true;
        if(canReach(arr, start - arr[start], visited) == true)
            return true;

        return false;
    }

    public static boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new boolean[arr.length]);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int b = 5;
        System.out.println(canReach(arr, b));
    }
}
