package leetCode;

public class CountingBits {
    public static  int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for(int i = 1; i<=n; i++) {
            int val =  (i & (i - 1));
            result[i] = result[val]+ 1;
        }
        return result;

    }

    public static void main(String[] args){
        int[] result = countBits(5);
        System.out.println("dne");
    }
}
