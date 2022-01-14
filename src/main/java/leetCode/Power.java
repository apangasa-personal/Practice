package leetCode;

public class Power {
    public static int pow(int A, int B, int C) {
        if (A == 0)
            return 0;
        if(B == 0)
            return 1;
        if(B == 1)
            return (C+A)%C;
        long result = pow(A, B/2, C);
        if(B%2 == 0)
            return (int)((C+(result%C * result%C))%C);
        else
            return (int)((C+(result%C * result%C * A%C)%C)%C);
    }

    public static void  main(String[] args){
        int A = -1 , B = 1 , C = 20;
        System.out.println(pow(A,B,C));

    }
}
