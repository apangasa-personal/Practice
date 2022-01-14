package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {
    public static int[][] anagrams(final String[] A) {
        HashMap<String, ArrayList<Integer>> entries = new HashMap<>();
        for(int i = 0 ; i< A.length; i++){
            char[] ar = A[i].toCharArray();
            Arrays.sort(ar);
            if(entries.containsKey(String.valueOf(ar))){
                ArrayList<Integer> currentIndexes = entries.get(String.valueOf(ar));
                currentIndexes.add(i+1);
                entries.put(String.valueOf(ar), currentIndexes);
            }
            else{
                ArrayList<Integer> currentIndexes = new ArrayList<>();
                currentIndexes.add(i+1);
                entries.put(String.valueOf(ar), currentIndexes);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(String key: entries.keySet())
            result.add(entries.get(key));
        int[][] intArray = result.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
        return intArray;
    }

    public static void main(String[] args){
        String[] A = {"cat", "dog", "god", "tca"};
        int[][] result = anagrams(A);
    }
}
