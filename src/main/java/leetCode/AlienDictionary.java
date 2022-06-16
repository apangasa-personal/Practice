package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"xy","xz"};
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        // Write your code here
        HashMap<Character, HashSet> adjacencyList = new HashMap<>();
        HashMap<Character, Boolean> visited = new HashMap<Character, Boolean>();
        HashSet<Character> charactersIterated = new HashSet<>();
        for(int i = 1; i< words.length; i++){
            for(int j = 0, k = 0; j < words[i-1].length() && k<words[i].length(); j++,k++){
                visited.put(words[i-1].charAt(j), false);
                visited.put(words[i].charAt(k), false);
                if(words[i-1].charAt(j) != words[i].charAt(k)){
                    if(!adjacencyList.containsKey(words[i-1].charAt(j))){
                        adjacencyList.put(words[i-1].charAt(j), new HashSet());
                    }
                    HashSet<Character> list = adjacencyList.get(words[i-1].charAt(j));
                    list.add(words[i].charAt(k));
                    adjacencyList.put(words[i-1].charAt(j), list);
                }
            }
        }
        String result = "";
        for(int i = adjacencyList.size() - 1; i >=0; i--){
            if(visited.get((char)adjacencyList.keySet().toArray()[i]) == false){
                result = dfs(visited, adjacencyList, result, (char)adjacencyList.keySet().toArray()[i], charactersIterated);
            }
        }
        for(int i = 1; i< words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(!charactersIterated.contains(words[i].charAt(j)))
                    result = result + words[i].charAt(j);
            }
        }
        return result;
    }

    public static String dfs(HashMap<Character, Boolean> visited,  HashMap<Character, HashSet> adjacencyList, String result, char ch, HashSet<Character> charactersIterated){
        result = result + ch;
        visited.put(ch, true);
        charactersIterated.add(ch);
        HashSet<Character> keys = (HashSet<Character>) adjacencyList.get(ch);
        if(keys != null) {
            for (char key : keys) {
                if (visited.get(key) == false) {
                    result = dfs(visited, adjacencyList, result, key, charactersIterated);
                }
            }
        }
        return result;
    }
}
