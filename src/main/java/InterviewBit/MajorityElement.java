package InterviewBit;

public class MajorityElement {

    public static int majorityElement(final int[] A) {
        int count = 1, majority = 0;
        for(int i = 1; i<A.length ; i++){
            if(A[i] == A[majority])
                count++;
            else
                count--;

            if(count == 0){
                majority = i;
                count = 1;
            }
        }
        return A[majority];
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(majorityElement(A));
    }
}
