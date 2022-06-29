package scaler.DSA;

public class SpecialInteger {
    public static boolean check(int[] A, int len, int B){
        long num = 0;
        for(int i = 0; i <= len; i++)
            num += (long)A[i];
        if(num > B)
            return false;
        for(int i = len+1; i< A.length; i++){
            num = num - (long)A[i - len-1] + A[i];
            if(num > B)
                return false;
        }
        return true;
    }

    public static int solve(int[] A, int B) {
        int start = 0, end = A.length - 1, ans = 0;
        while (start <= end){
            int mid = (start+end)/2;
            if(check(A, mid, B)) {
                start = mid + 1;
                ans = mid+1;
            }
            else
                end = mid -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A, 10));
    }
}
