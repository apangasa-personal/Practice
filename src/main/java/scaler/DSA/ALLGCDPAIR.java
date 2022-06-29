package scaler.DSA;

import java.util.*;

public class ALLGCDPAIR {
    public static int gcd(int A, int B) {
        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }
        if(A == 0)
            return B;
        while( A > 0){
            int temp = A;
            A = (B-A)%A;
            B = temp;
        }
        return B;
    }

    public static int[] solve(int[] A) {
        HashMap<Integer, Integer> values = new HashMap<>();
        Arrays.sort(A);
        for(int i = 0; i<A.length; i++){
            if(values.containsKey(A[i]))
                values.put(A[i], values.get(A[i]) + 1);
            else
                values.put(A[i],1);
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=A.length - 1; i>=0; i--){
            if(i == A.length - 1) {
                result.add(A[i]);
                if(values.containsKey(A[i]))
                    values.put(A[i], values.get(A[i]) - 1);
                if(values.get(A[i]) == 0)
                    values.remove(A[i]);
            }
            else{
                if(values.containsKey(A[i])){
                    for(int j = 0; j<result.size(); j++){
                        int val = gcd(A[i], result.get(j));
                        values.put(val, values.get(val) - 2);
                        if(values.get(val) == 0)
                            values.remove(val);
                    }
                    result.add(A[i]);
                    values.put(A[i], values.get(A[i]) - 1);
                    if(values.get(A[i]) == 0)
                        values.remove(A[i]);
                }
            }
        }
        return result.stream().mapToInt(Number:: intValue).toArray();
    }

    public static int[] reverse(int[] input)
    {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++)
        {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
        return input;
    }

    static int[] findNumbers(int[] arr, int n) {
        Arrays.sort(arr);
        arr = reverse(arr);
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(values.containsKey(arr[i]))
                values.put(arr[i], values.get(arr[i]) + 1);
            else
                values.put(arr[i],1);
        }
        int size = (int) Math.sqrt(n);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if(values.get(arr[i]) > 0)
                result.add(arr[i]);
            for(int j = i+1; j<n-2; j++){
                int gcd = gcd(arr[i], arr[j]);
                if(values.get(gcd) > 0 && arr[j] != arr[j-1])
                    values.put(gcd, values.get(gcd) - 2);
                if(values.get(gcd) < 0)
                    values.remove(gcd);
            }
        }
        return values.keySet().stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] arg){
        int[] A = {46, 1, 2, 1, 1, 1, 5, 45, 1, 1, 2, 5, 1, 40, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1};
        solve(A);
    }
}
