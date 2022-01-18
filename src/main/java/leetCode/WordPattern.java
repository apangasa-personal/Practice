package leetCode;

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        for(int i = 0; i<pattern.length(); i++){
            String word = words[i];
            char ch = pattern.charAt(i);
            if(map1.containsKey(word) || map2.containsKey(ch)){
                if(map1.containsKey(word) == false || map2.containsKey(ch) == false)
                    return false;
                String wordc = map2.get(pattern.charAt(i));
                char chc = map1.get(words[i]);
                if(!(wordc.equals(words[i]) && pattern.charAt(i) == chc))
                return false;
            }
            else {
                map1.put(words[i], pattern.charAt(i));
                map2.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }
}
