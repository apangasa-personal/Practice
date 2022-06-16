package leetCode;

import java.util.HashMap;

public class VerifyAnAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            characterMap.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++){
            if(!checkWords(words[i-1], words[i], characterMap))
                return false;
        }
        return true;
    }

    public static boolean checkWords(String word1, String word2, HashMap<Character, Integer> characterMap){
        int i = 0, j = 0;
        for(; i < word1.length() && j < word2.length(); i++,j++){
            if(characterMap.get(word1.charAt(i)) < characterMap.get(word2.charAt(j)))
                return true;
            else if(characterMap.get(word1.charAt(i)) > characterMap.get(word2.charAt(j)))
                return false;
        }
        if(i != word1.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"kuvp","q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(isAlienSorted(words, order));
    }
}
