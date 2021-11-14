package scaler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

    //check palindrome
    public static int solve(String A, int start, int end){
        if(A.charAt(start) != A.charAt(end))
            return 0;
        else if (start > end)
            return 1;
        return solve(A, ++start, --end);
    }

    //alterString
    public static String alterString(String str, int index){
        if(index == str.length())
            return str;
        else if(str.charAt(index) > 64 && str.charAt(index) < 91) {
            String result = str.substring(0, index) + str.substring(index + 1);
            return alterString(result,index);
        }
        else
            return alterString(str,index+1);
    }

    //fibo
    public static int fibo(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else return fibo(n-1) + fibo(n-2);
    }

    //reverseString
    public static void printReverse(String str){
        if(str.length() == 0)
            return;
        else{
            System.out.print(str.charAt(str.length() - 1));
            printReverse(str.substring(0, str.length() - 1));
        }
    }

    //dig sim
     public static int sum(int n){
        if (n == 0)
            return 0;
        else{
            int digit = n%10;
            return digit + sum(n/10);
        }
     }

     static int apowerN(int a,int n){
        if(n%2 != 0)
            return apowerN(a,n/2) * apowerN(a,n/2) * a;
        else
            return apowerN(a,n/2) * apowerN(a,n/2);
     }

    static int bar(int x, int y){
        if(y==0) return 0;
        return (x+bar(x,y-1));
    }

    static int foo(int x, int y){
        if(y==0) return 1;
        return bar(x, foo(x,y-1));
    }

    //magicNumber
    public static int magicNumber(int A){
        if(A==0)
            return 0;
        return A%10 + magicNumber(A/10);

    }

    static long power(long x, long y, long z)
    {
        long temp;
        if( y == 0)
            return 1;
        temp = power(x, y / 2,z);
        if (y % 2 == 0)
            return ((temp%z)*(temp%z))%z;
        else
            return ((x%z)*(temp%z)*(temp%z))%z;
    }


    public static int kthElement(int A, int B){
        if(A == 1 && B == 1)
            return  0;
        else{
            int length = (int) Math.pow(2,A-1);
           if(B<=length/2)
               return kthElement(A-1,B);
            else
               return ~kthElement(A-1,B-length/2);
        }
    }

    public static int anotherSequenceProblem(int A) {
        if(A==0 || A== 1)
            return 1;
        else if (A== 2)
            return 2;
        else return A + anotherSequenceProblem(A-1) + anotherSequenceProblem(A-2) + anotherSequenceProblem(A-3);
    }

    //find expo and modulo
    public static long anotherPow(long A, long B, long C) {
        if(A==0)
            return 0;
        else if(B == 1)
            return A;
        else if(B == 0)
            return 1;
        if(B%2 == 0) {
            return  (long)(anotherPow(A, (long)B / 2, C)%C * anotherPow(A, (long)B / 2, C)%C) % C;
        }
        else {
            return  (long)(anotherPow(A, (long) Math.floor(B / 2), C)%C * anotherPow(A, (long)Math.floor(B / 2), C)%C * (A%C)) % C;
        }
    }

    public static int pow(long A, long B, long C) {
        long result = 1;
        if(A==0)
            return(0);
        else if(B == 1)
            return (int) ((A+C)%C);
        while(B != 0){
            if(B%2 == 0){
                A = ((A%C) * (A%C))%C;
                B = B/2;
            }
            else {
                result = ((result % C) * (A % C)) % C;
                B--;
            }
        }
        result = result + C;
        return (int) ((int)result%C);
    }

    static void decimalToBinaryNumber(int x, int n)
    {
        int[] binaryNumber = new int[x];
        int i = 0;
        while (x > 0) {
            binaryNumber[i] = x % 2;
            x = x / 2;
            i++;
        }

        // leftmost digits are
        // filled with 0
        for (int j = 0; j < n - i; j++)
            System.out.print('0');

        for (int j = i - 1;
             j >= 0; j--)
            System.out.print(binaryNumber[j]);
    }

    public ArrayList<Integer> grayCode(int n) {
        int N = 1 << n;
        for (int i = 0; i < N; i++) {
            int x = i ^ (i >> 1);
            decimalToBinaryNumber(x, n);
            System.out.println();
        }
        return null;
    }

    static ArrayList<Integer> generateGrayarr(int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int N = 1 << n;
        for (int i = 0; i < N; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

//    public static int kthElementNew(int N, int K) {
//       long elements = (int) Math.pow(2,N);
//       long mid = elements/2 - 1;
//       if(N == 0)
//           return 1;
//
//    }

//    static ArrayList<ArrayList<Integer>> towerOfHanoi(int n, char A, char B, char C)
//    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        ArrayList< ArrayList<Integer>> finalResult = new ArrayList<>();
//        if (n == 1)
//        {
//            temp.clear();
//            temp.add(n); temp.add((int) A); temp.add((int) C);
//            finalResult.add(temp);
//            return finalResult;
//        }
//        return towerOfHanoi(n - 1, A, B, C);
//        System.out.println("Move disk "+ n + " from rod " + A +" to rod " + B );
//        return towerOfHanoi(n - 1, B, A, C);
//    }


    private static void moveDisks(int n, int toRod, int fromRod, ArrayList < ArrayList<Integer>> moves)
    {
        if (n == 1)
        {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(n);
            ans.add(fromRod);
            ans.add(toRod);
            moves.add(ans);
            return;
        }
        int rem = 1 ^ 2 ^ 3 ^ toRod ^ fromRod;
        moveDisks(n - 1, rem, fromRod, moves);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n);
        ans.add(fromRod);
        ans.add(toRod);
        moves.add(ans);
        moveDisks(n - 1, toRod, rem, moves);
    }

    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n)
    {
        ArrayList < ArrayList<Integer>> moves = new ArrayList<>();
        moveDisks(n, 3, 1, moves);
        return moves;
    }

    //main
    public static void main(String[] args){
        towerOfHanoi(1);
        System.out.println("done");

    }
}
