package scaler.DSA;

public class ComplementOfBase10Integer {
    public static int bitwiseComplement(int n) {
        int[] element = new int[32];
        int start = 31;
        while(n > 0){
            if(n%2 == 1)
                element[start] = 1;
            start--;
            n = n>>1;
        }
        int result = 0, power = 1;
        int end = 31;
        while(end > start){
            if(element[end] == 0)
                result = result + power;
            power = power * 2;
            end--;
        }
        return result;
    }

    public static void main(String[] args) {
        int i= 5;
        System.out.println(bitwiseComplement(i));
    }
}
