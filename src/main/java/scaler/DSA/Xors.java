package scaler.DSA;

import java.util.HashMap;

public class Xors {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int m = 5;
        long ans = 0;
        int n = arr.length;

        int[] xorArr = new int[n];

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        xorArr[0] = arr[0];
        for (int i = 1; i < n; i++)
            xorArr[i] = xorArr[i - 1] ^ arr[i];

        for (int i = 0; i < n; i++) {
            int tmp = m ^ xorArr[i];
            ans = ans + (mp.containsKey(tmp) == false ? 0 : ((long)mp.get(tmp)));
            if (xorArr[i] == m)
                ans++;

            if (mp.containsKey(xorArr[i]))
                mp.put(xorArr[i], mp.get(xorArr[i]) + 1);
            else
                mp.put(xorArr[i], 1);
        }
        return ;
    }
}
