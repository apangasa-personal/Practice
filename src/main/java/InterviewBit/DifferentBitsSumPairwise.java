package InterviewBit;

public class DifferentBitsSumPairwise {
    public static int count(int[] A){
        int ans = 0;
        for(int i = 0; i< 32; i++){
            int count = 0;
            for(int j = 0; j< A.length; j++){
                if((A[j] & (1<<i)) != 0)
                    count++;
            }
            ans += count * (A.length - count) * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        System.out.println(count(A));
    }
}
