package scaler;

public class MaximumAbsoluteDifference {
    public static int maxArr(int[] A) {
        int[] less = new int[A.length];
        int[] more = new int[A.length];
        for(int i = 0; i< A.length; i++){
            less[i] = A[i] + i;
            more[i] = A[i] - i;
        }
        int sumMax = Integer.MIN_VALUE;
        int temp = 0;
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MIN_VALUE;
        for(int i = 0; i< A.length; i++){
            element1 = Math.min(element1, less[i]);
            element2 = Math.max(element2, less[i]);
        }
        sumMax = element2 - element1;
        element1 = Integer.MAX_VALUE;
        element2 = Integer.MIN_VALUE;
        for(int i = 0; i< A.length; i++){
            element1 = Math.min(element1, more[i]);
            element2 = Math.max(element2, more[i]);
        }
        sumMax = Math.max(element2 - element1, sumMax);
        return sumMax;
    }
    public static void main(String[] args){
        int[] A = {1, 3, -1};
        System.out.println(maxArr(A));
    }
}
