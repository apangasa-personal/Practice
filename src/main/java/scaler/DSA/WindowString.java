package scaler.DSA;

import java.util.HashMap;

public class WindowString {

    public static boolean compare(int[] actual, int[] expected){
        for(int i = 0; i< actual.length; i++){
            if(actual[i] < expected[i])
                return false;
        }
        return true;
    }

    public static String solve(String A, String B){
        if(A.length() < B.length())
            return "";
        int[] actual = new int[256];
        int[] expected = new int[256];
        int start = 0, end = 0, fStart= 0, fEnd = 0, result = Integer.MAX_VALUE;
        for(int i = 0; i< B.length(); i++) {
            expected[B.charAt(i)]++;
            actual[A.charAt(i)]++;
        }
        if(compare(actual, expected)) {
            if (result > end - start) {
                result = end - start;
                fStart = start;
                fEnd = B.length();
            }
        }
        for(end = B.length(); end < A.length(); end++){
            actual[A.charAt(end)]++;
            if(compare(actual, expected)){
                while(start < end && expected[A.charAt(start)] < actual[A.charAt(start)]) {
                    actual[A.charAt(start)]--;
                    start++;
                }
                if(result > end - start){
                    result = end - start;
                    fStart = start;
                    fEnd = end+1;
                }
            }
        }

        return A.substring(fStart, fEnd);
    }

    public static void main(String[] args) {
        String A = "ZCRVpoDVpWvwexDhBm43OmKcSSq3EV89L1iEvZkFQ3CuwGZ4bt3uQFAWtnW8R4zOoFbPuFf9PWbZGxUaelCi88dLZMw77W2VGVtKO4rYl361MBRa51fdxb46zlNNOAViT718vddMQgPU30P3Vm4u5zVAXgOgN8fieoHwBLCID7GeZIMmxt6YZpvKKqRsfay1E0cgKjWvak9JHdwHSsoN8eRB0ZP6xRQojkIl8dqH6i5mQf21X7JhgJ5xd6smRbv0KPmyns3YHeNHc9oGNi4KGIhjiiaPYl4f8YQ6U7PEYIwv6guxv3QGpUcVEtwsydy53vTKppaXdQfrd4PSqnz8I4716g9fCSWzq8oMSsrir0u3k1IRIB75",
               B = "dNaoGdgMNQG9";

        System.out.println(solve(A,B));
    }
}
