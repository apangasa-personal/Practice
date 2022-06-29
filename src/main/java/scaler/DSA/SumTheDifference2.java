package scaler.DSA;

public class SumTheDifference2 {
    public static int partition(int[] A, int start, int end){
        int l1 = start+1, l2 = end;
        while(l1 <= l2){
            if(A[l1] < A[start])
                l1++;
            else if(A[l2] > A[start])
                l2--;
            else{
                int temp = A[l1];
                A[l1] = A[l2];
                A[l2] = temp;
                l1++;
                l2--;
            }
        }
        int temp = A[l1-1];
        A[l1-1] = A[start];
        A[start] = temp;
        return l1-1;
    }

    public static void quickSort(int[] A, int start, int end){
        if(start >= end)
            return;
        int partition = partition(A, start, end);
        quickSort(A, start, partition-1);
        quickSort(A, partition+1, end);
    }

    public static int solve(int[] A) {
        long power = 1, element1 = 0, element2 = 0;
        long mod = 1000000007;
        quickSort(A, 0, A.length-1);
        for(int i = 0; i<A.length; i++){
            element1 = (element1 + power%mod * A[i]%mod)%mod;
            power = (power%mod * 2) % mod;
        }

        power = 1;
        for(int i = A.length - 1; i >= 0; i--){
            element2 = (element2 + power%mod * A[i]%mod)%mod;
            power = (power%mod * 2) % mod;
        }
        return (int)((element1 - element2 + mod)%mod);
    }

    public static void main(String[] args) {
        int[] A = {7, 8, 6, 4, 6 };
        System.out.println(solve(A));

    }
}
