package scaler.DSA;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class RateLimiter {


    public static int maximmumHarvest(int[] arr,int totalContinuous){
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<n/2;i++){
            int sum = 0;
            int currentIndex = -1;
            int oppositeIndex = -1;
            for(int j=0;j<totalContinuous;j++){
                currentIndex= i+j;
                oppositeIndex= (currentIndex+(n/2))%n;
                sum += arr[currentIndex]+arr[oppositeIndex];
            }
            maxProfit = Math.max(maxProfit,sum);
        }
        return maxProfit;
    }

    public static int maximmumHarvest1(int[] arr,int totalContinuous){
        int length = arr.length;
        int half_length = length / 2;
        int max = 0;
        for (var i = 0; i < totalContinuous; i ++) {
            max += arr[i];
            max += arr[(i+half_length) % length];
        }

        int current_profit = max;
        for (var i = 1; i < length/2; i ++) {
            current_profit -= arr[i - 1];
            current_profit -= arr[(i - 1 + half_length) % length];

            current_profit += arr[i + totalContinuous - 1];
            current_profit += arr[(i + totalContinuous - 1 + half_length) % length];
            max = Math.max(max, current_profit);
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        int result = maximmumHarvest1(arr, 2);
        System.out.println(result);
    }
}
