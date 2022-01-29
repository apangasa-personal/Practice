package leetCode;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int fuelReserve = 0, totalReserve = 0, start = 0;
        for(int i = 0; i< gas.length; i++) {
            fuelReserve += gas[i] - cost[i];
            totalReserve += gas[i] - cost[i];
            if(fuelReserve < 0){
                start = i+1;
                fuelReserve = 0;
            }
        }
        if(totalReserve < 0)
            return -1;
        else
            return start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
