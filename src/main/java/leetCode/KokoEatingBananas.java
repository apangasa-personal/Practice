package leetCode;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i<piles.length; i++)
            max = Math.max(max, piles[i]);

        int start = 1, result = 0;
        while (start <= max){
            int mid = (start + max)/2, hoursconsumed = 0;
            for(int i = 0; i < piles.length ; i++){
                hoursconsumed += piles[i]/mid + 1;
                if(piles[i]%mid == 0)
                    hoursconsumed--;
            }
            if(hoursconsumed <= h){
                result = mid;
                max = mid-1;
            }
            else
                start = mid+1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] bananas = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(bananas, h));
    }
}
