package scaler.DSA;

public class FirstMissingInteger {
    public static int firstMissingPositive(int[] A) {
        int i = 0;
        int j = 1;
        while(i < A.length){
            if(A[i] == (i+1))
                i++;
            else{
                if(A[i] >= 1 && A[i] <= A.length){
                    int temp = A[i];
                    if(A[i] == A[temp-1])
                        i++;
                    else {
                        A[i] = A[temp - 1];
                        A[temp - 1] = temp;
                    }
                }
                else
                    i++;
            }
        }
        for( i = 0; i< A.length; i++)
            if(A[i] != (i+1))
                return i+1;
        return 0;
    }
    public static void main(String[] args){
        int[] A = {2, 3, 1, 2};
        System.out.println(firstMissingPositive(A));
    }

}
