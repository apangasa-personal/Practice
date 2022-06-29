package scaler.DSA;

import java.util.Arrays;

public class ComputenCrModm {
    public static int solve(int A, int B, int C) {
        int[] result = new int[B+1];
        result[0] = 1;result[1] = 1;
        int[] next = new int[B+1];
        for(int i = 2; i <= A; i++){
            for(int j = 0; j<= B; j++){
                if(j == 0){
                    next[j] = result[j];
                }
                else {
                    next[j] = (result[j]%C + result[j-1]%C)%C;
                }
            }
            result = Arrays.copyOf(next, next.length);
        }
        return result[B];
    }

    public static int power(long A, int B, int C){
        if(A == 0)
            return 1;
        if(B == 0)
            return 1;
        if(B == 1)
            return (int)A%C;
        long result = power(A, B/2, C);
        if(B%2 == 1)
            return (int)(result * result * A%C)%C;
        return (int)(result * result)%C;
    }
    public static int solveFermat(int A, int B, int C) {
        long component1 = 1, component2 = 1, component3 = 1;
        for(int i = 2; i<=A; i++)
            component1 = (component1%C * i%C)%C;
        for(int i = 2; i<=B; i++)
            component2 = (component2%C * i%C)%C;
        for(int i = 2; i<=A-B; i++)
            component3 = (component3%C * i%C)%C;
        component3 = (C + power(component3, C - 2, C))%C;
        component2 = (C + power(component2, C - 2, C))%C;

        return (int)(C + (component1%C * component2%C * component3%C))%C;
    }

    public static void main(String[] args){
        int A = 281 , B = 174, C = 47681;
        System.out.println(solve(A,B,C));
        System.out.println(solveFermat(A,B,C));
    }
}
