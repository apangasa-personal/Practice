package scaler.DSA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {

    static class CarSlot{
        int time, cost;

        public CarSlot(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    public static class CustomComparatorTime implements Comparator<CarSlot>{
        public int compare(CarSlot first, CarSlot second){
            if( first.time < second.time)
                return -1;
            else if(first.time == second.time)
                return 0;
            else
                return 1;
        }
    }

    public static class CustomComparatorCost implements Comparator<CarSlot>{
        public int compare(CarSlot first, CarSlot second){
            if( first.cost < second.cost)
                return -1;
            else if(first.cost == second.cost)
                return 0;
            else
                return 1;
        }
    }

    public static int solve(int[] A, int[] B) {
        PriorityQueue<CarSlot> carSlots = new PriorityQueue<>(new CustomComparatorTime());
        for(int i = 0; i < A.length; i++){
            carSlots.offer(new CarSlot(A[i], B[i]));
        }
        PriorityQueue<CarSlot> result = new PriorityQueue<>(new CustomComparatorCost());
        while (carSlots.size() > 0){
            CarSlot carSlot = carSlots.poll();
            result.offer(carSlot);
            while(result.size() > carSlot.time)
                result.poll();
        }
        int finalValue = 0;
        while (result.size() > 0)
            finalValue = finalValue + result.poll().cost;
        return finalValue;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 3}, B = {5, 6, 1, 3, 9};
        System.out.println(solve(A, B));
    }

}
