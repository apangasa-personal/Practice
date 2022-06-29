package scaler.DSA;

import java.util.Scanner;

public class PrintReverseString {
    public static void printStr(String str){
        if(str.length() == 0)
            return;
        System.out.print(str.charAt(str.length() - 1));
        printStr(str.substring(0, str.length() - 1));
    }
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        String str = myObj.nextLine();  // Read user input
        printStr("scaleracademy");
    }
}
