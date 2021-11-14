package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    public static List<Integer> solve(String s, String[] words){
        int wordLength = words[0].length();
        List<Integer> result = new LinkedList<>();
        HashMap<String, Integer> elements = new HashMap<>();
        for(int i = 0; i< words.length; i++){
            if(elements.containsKey(words[i]))
                elements.put(words[i], elements.get(words[i]) + 1);
            else
                elements.put(words[i], 1);
        }
        HashMap<String, Integer> elementsClone = (HashMap<String, Integer>) elements.clone();
        String word = "";
        final int endLength = s.length() - wordLength * words.length +1;
        for(int i = 0; i< endLength; i++){
            elementsClone = (HashMap<String, Integer>) elements.clone();
            word = s.substring(i,i+wordLength);
            int j = i;
            while(elementsClone.containsKey(word)) {
                if(elementsClone.get(word) == 1)
                    elementsClone.remove(word);
                else
                    elementsClone.put(word, elementsClone.get(word) - 1);
                j= j+wordLength;
                if(j<=s.length()-wordLength)
                    word = s.substring(j,j+wordLength);
            }
            if(elementsClone.keySet().size() == 0)
                result.add(i);
        }
        return result;
    }
    public static void main(String[] args){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> result = solve(s, words);
        System.out.println(result.toArray().toString());
    }
}
