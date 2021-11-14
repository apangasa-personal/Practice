package hackerRank;

import java.util.Arrays;
import java.util.*;


public class Swaps {
    public static void swap(Integer[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int checkOrder(Integer[] temp, Integer[] unsorted, HashMap<Integer, Integer> h){
        int ans = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (unsorted[i] != temp[i])
            {
                ans++;
                int init = unsorted[i];

                // If not, swap this element
                // with the index of the
                // element which should come here
                swap(unsorted, i, h.get(temp[i]));

                // Update the indexes in
                // the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }

    public static int lilysHomework(List<Integer> arr1) {
        Integer[] sortedValue = arr1.toArray(Integer[]::new);
        Integer[] unsortedValues = arr1.toArray(Integer[]::new);
        int swaps1 = 0, swap2 = 0;

        Map<Integer, Integer> locations = new HashMap<>();
        for (int i = 0; i < unsortedValues.length; i++) {
            locations.put(unsortedValues[i], i);
        }

        sortedValue = unsortedValues.clone();
        Arrays.sort(sortedValue);

        for (int i = 0; i < sortedValue.length; i++) {
            if (sortedValue[i] != unsortedValues[i]) {
                swaps1++;

                int swapIndex = locations.get(sortedValue[i]);
                locations.put(unsortedValues[i], swapIndex);

                swap(unsortedValues, i, swapIndex);
            }
        }

        Arrays.sort(sortedValue, Collections.reverseOrder());
        unsortedValues = arr1.toArray(Integer[]::new);

        for (int i = 0; i < unsortedValues.length; i++) {
            locations.put(unsortedValues[i], i);
        }

        for (int i = 0; i < sortedValue.length; i++) {
            if (sortedValue[i] != unsortedValues[i]) {
                swap2++;

                int swapIndex = locations.get(sortedValue[i]);
                locations.put(unsortedValues[i], swapIndex);

                swap(unsortedValues, i, swapIndex);
            }
        }


        return Math.min(swap2, swaps1);
    }

    public static void main(String[] args){
        Integer[] val = {3, 4, 2, 5, 1};
        List<Integer> arr1 = Arrays.asList(val);
        int ans = lilysHomework(arr1);
        System.out.println(ans);
    }
}
