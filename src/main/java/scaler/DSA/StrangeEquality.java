package scaler.DSA;

public class StrangeEquality {
    public static int solve(int A) {
        int msb = 0, temp = A;
        while(temp > 0){
            msb++;
            temp = temp >> 1;
        }
        int x = 0, y = 0;
        for(int i = 0; i< msb; i++){
            int val = A >> i;
            if((val & 1) == 0) {
                x += 1 << i;
            }
        }
        y = 1 << msb;
        return x^y;
    }

    public static void main(String[] args){
        int A = 4;
        System.out.println(solve(A));
    }
}
