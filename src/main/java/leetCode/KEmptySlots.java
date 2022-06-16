package leetCode;

public class KEmptySlots {
    public static int kEmptySlots(int[] flowers, int k) {
        // Write your code here
        int[] bloomed = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++)
            flowers[i]--;
        bloomed[flowers[0]] = 1;
        for(int i = 1; i < flowers.length; i++){
            bloomed[flowers[i]] = 1;
            if(flowers[i] - k - 1 >= 0 && bloomed[flowers[i] - k - 1] == 1){
                if(checkUnbloomed(flowers[i]-k+1, flowers[i], bloomed) == true)
                    return i+1;
            }
            if(flowers[i]+k+1 <= bloomed.length - 1 && bloomed[flowers[i]+k+1] == 1){
                if(checkUnbloomed(flowers[i]+1, flowers[i]+k, bloomed) == true)
                    return i+1;
            }
        }
        return -1;
    }

    public static boolean checkUnbloomed(int start, int end, int[] bloomed){
        while(start <= end){
            if(bloomed[start] == 1)
                return false;
            start++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] flowers = {9,1,4,2,8,7,5,3,6,10};
        int k = 3;
        System.out.println(kEmptySlots(flowers, k));
    }
}
