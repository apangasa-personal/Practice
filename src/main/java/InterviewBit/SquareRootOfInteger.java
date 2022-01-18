package InterviewBit;

public class SquareRootOfInteger {
    public static int sqrt(int A) {
        if(A == 0)
            return 0;
        int start = 1;
        int end = A/2;
        int mid = 1, result = mid;
        while(start <= end){
            mid = (start + end)/2;
            if((long)(mid) * mid <= A) {
                result = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 930675566;
        System.out.println(sqrt(a));
    }
}
