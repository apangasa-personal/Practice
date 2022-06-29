package scaler.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MapSumPairs {

    static class Trie{
        HashMap<Character, Trie> next = new HashMap<>();
        int weight;
    }

    static Trie root = new Trie();
    public static int[] solve(String[] A, int[] B) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< A.length; i++) {
            if(B[i] == -1) {
                result.add(search(root, A[i]));
            }
            else
                insertInTrie(A[i], B[i]);
        }
        return result.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static int searchCore(Trie temp, int result){
        if(temp.weight != 0)
            result += temp.weight;
        for(Character key : temp.next.keySet()){
            result = result + search(temp.next.get(key), "");
        }
        return result;
    }

    public static int search(Trie temp, String s){
        for(int i = 0; i < s.length(); i++){
            if(!temp.next.containsKey(s.charAt(i)))
                return 0;
            temp = temp.next.get(s.charAt(i));
        }
        return searchCore(temp, 0);
    }


    public static void insertInTrie(String s, int weight){
        Trie temp = root;
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!temp.next.containsKey(ch))
                temp.next.put(ch, new Trie());
            temp = temp.next.get(ch);
        }
        temp.weight = weight;
    }

    public static void main(String[] args) {
        String[] A = {"apple", "ap", "app", "ap"};
        int[] B = {3, -1, 2, -1};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
