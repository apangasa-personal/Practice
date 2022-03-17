package scaler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {
    public static class Fraction{
        int numerator;
        int denominator;
        double value;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.value = numerator * 1D/ denominator;
        }
    }

    public static class FractionComparator implements Comparator<Fraction>{
        @Override
        public int compare(Fraction a, Fraction b){
           if(a.value < b.value)
               return -1;
           else if(a.value > b.value)
               return 1;
           else
               return 0;
        }
    }

    public static int[] solve(int[] A, int B) {
        PriorityQueue<Fraction> fractionPriorityQueue = new PriorityQueue<>(new FractionComparator());
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(A[i] < A[j]){
                    Fraction fractionObject = new Fraction(A[i], A[j]);
                    fractionPriorityQueue.offer(fractionObject);
                }
            }
        }
        int[] result = new int[2];
        for(int i = 0; i < B  && !fractionPriorityQueue.isEmpty(); i++){
            Fraction fractionObject = fractionPriorityQueue.poll();
            result[0] = fractionObject.numerator;
            result[1] = fractionObject.denominator;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297}; int B = 42;
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
