package leetCode;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
            return true;
        for (int i = 0; i<flowerbed.length - 1; i++){
            if(flowerbed[i] == 1)
                continue;
            if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && (i == 0 || flowerbed[i-1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0)
                return true;
        }
        if(flowerbed[flowerbed.length - 1] == 0 && ((flowerbed.length - 1 >= 1 && flowerbed[flowerbed.length - 2] == 0) || flowerbed.length - 1 == 0))
            n--;
        if(n == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
