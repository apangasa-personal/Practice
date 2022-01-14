package leetCode;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int[] maxRight = new int[prices.length];
        maxRight[prices.length - 1] = prices[prices.length-1];
        for(int i = prices.length - 2;i>=0; i--)
            maxRight[i] = Math.max(maxRight[i+1], prices[i]);
        int result = 0;
        for(int i = 0; i<prices.length; i++){
            result = Math.max(result, maxRight[i] - prices[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {7,1,5,3,6,4};
        System.out.println(maxProfit(A));
    }
}
