package scaler.DSA;

import java.util.*;

public class NmaxPair {

    public static class CalculatedValue{
        int sum;
        int firstArrayIndex;
        int secondArrayIndex;

        public CalculatedValue(int sum, int firstArrayIndex, int secondArrayIndex) {
            this.sum = sum;
            this.firstArrayIndex = firstArrayIndex;
            this.secondArrayIndex = secondArrayIndex;
        }
    }

    public static class ComparatorCustom implements Comparator<CalculatedValue>{
        public int compare(CalculatedValue a, CalculatedValue b){
            if(a.sum < b.sum)
                return 1;
            return -1;
        }
    }

    public static int[] solve(int[] A, int[] B) {
        Arrays.sort(A); Arrays.sort(B);
        PriorityQueue<CalculatedValue> priorityQueue = new PriorityQueue<CalculatedValue>(new ComparatorCustom());
        Set<String> set = new HashSet<>();
        int[] result = new int[A.length];
        int resultCounter = 0;
        priorityQueue.offer(new CalculatedValue(A[A.length - 1] + B[A.length - 1], A.length - 1, B.length - 1));
        while(resultCounter < A.length){
            CalculatedValue currentValue = priorityQueue.poll();
            result[resultCounter] = currentValue.sum;
            if(currentValue.firstArrayIndex > 0 && !set.contains(currentValue.firstArrayIndex-1 + "," + currentValue.secondArrayIndex)){
                priorityQueue.offer(new CalculatedValue(A[currentValue.firstArrayIndex-1] + B[currentValue.secondArrayIndex], currentValue.firstArrayIndex-1, currentValue.secondArrayIndex));
                set.add(currentValue.firstArrayIndex-1 + "," + currentValue.secondArrayIndex);
            }
            if(currentValue.secondArrayIndex > 0 && !set.contains(currentValue.firstArrayIndex + "," + String.valueOf(currentValue.secondArrayIndex-1))){
                priorityQueue.offer(new CalculatedValue(A[currentValue.firstArrayIndex] + B[currentValue.secondArrayIndex-1], currentValue.firstArrayIndex, currentValue.secondArrayIndex-1));
                set.add(currentValue.firstArrayIndex + "," + String.valueOf(currentValue.secondArrayIndex-1));
            }
            resultCounter++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 1, 1};
        int[] B = {-2, -3, 2, 4};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
