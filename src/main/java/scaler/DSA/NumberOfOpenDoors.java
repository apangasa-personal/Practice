package scaler.DSA;

public class NumberOfOpenDoors {
    static int value = 1;
    public static int solve(int A) {
        int result = 0;
        int value = 1;
        for(int i = 1; i<=A; i++){
            value =(int)Math.sqrt(i);
            if(value * value == i)
                result++;
        }
        return result;
    }

    public static void main(String[] args){
        int A = 8319236;
        System.out.println(solve(A));
    }
}
