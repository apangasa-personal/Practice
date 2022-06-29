package scaler.DSA;

public class SelectionSort {
    public static int[] sorted(int[] A){
        int i = 0, j = 0, smallest = Integer.MAX_VALUE, smallestIndex = 0;
        for( i = 0; i<A.length; i++){
            smallest = A[i];
            smallestIndex = i;
            for( j = i+1; j<A.length; j++){
                if(smallest > A[j]){
                    smallest = A[j];
                    smallestIndex = j;
                }
            }
            if(i!= smallestIndex) {
                A[i] = A[smallestIndex] ^ A[i];
                A[smallestIndex] = A[smallestIndex] ^ A[i];
                A[i] = A[smallestIndex] ^ A[i];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A= {7,4,-3,0};
        A = sorted(A);
        System.out.println("done");
    }
}
