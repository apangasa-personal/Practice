package leetCode;

public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        long min = 1, max = n, mid = 1;
        long result = 0;
        while(min <= max){
            mid = (min + max)/2;
            if(isBadVersion((int)mid)){
                result = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return (int)result;
    }
    public static boolean isBadVersion(int n){
        if(n>=1702766719)
            return true;
        return false;
    }

    public static void main(String[] args){
        int n = 2126753390;
        System.out.println(firstBadVersion(n));
    }
}
