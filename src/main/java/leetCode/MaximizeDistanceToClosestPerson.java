package leetCode;

public class MaximizeDistanceToClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        int[] prefilled = new int[seats.length];
        int[] postfilled = new int[seats.length];
        prefilled[0] = -1;
        postfilled[postfilled.length - 1] = postfilled.length;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1)
                prefilled[i] = i;
            else {
                if(i > 0)
                    prefilled[i] = prefilled[i - 1];
            }
        }
        for(int i = seats.length - 1; i >= 0; i--){
            if(seats[i] == 1)
                postfilled[i] = i;
            else{
                if(i <seats.length - 1)
                    postfilled[i] = postfilled[i+1];
            }
        }
        int result = 0, seatNum = -1;
        for(int i = 0; i< seats.length; i++){
            if(prefilled[i] == i)
                continue;
            int num1 = i - prefilled[i];
            int num2 = postfilled[i] - i;
            if(i == 0 && seats[i] == 0)
                num1 = Integer.MAX_VALUE;
            if(i == seats.length - 1 && seats[i] == 0)
                num2 = Integer.MAX_VALUE;
            if(result < Math.min(num1, num2)){
                result = Math.min(num1, num2);
                seatNum = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] seats = {0,1};
        System.out.println(maxDistToClosest(seats));
    }
}
