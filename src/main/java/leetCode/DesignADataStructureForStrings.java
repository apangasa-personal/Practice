package leetCode;
import java.util.*;

public class DesignADataStructureForStrings {
    Map<Integer, List<String>> words = new HashMap<Integer, List<String>>();
    public void addWord(String word) {
        int index = word.length();
        if(!words.containsKey(index)){
            List<String> list = new ArrayList<>();
            list.add(word);
            words.put(index, list);
        }
        else{
            words.get(index).add(word);
        }
    }

    public boolean search(String word) {
        int index = word.length();
        if(!words.containsKey(index)){
            return false;
        }
        List<String> list = words.get(index);
        if(exactWordMatch(word)){
            return list.contains(word);
        }
        for(String s : list){
            if(checkWithDot(s, word)){
                return true;
            }
        }
        return false;
    }
    boolean exactWordMatch(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    boolean checkWithDot(String a, String search){
        if(a.length() != search.length()){
            return false;
        }
        for(int i = 0; i < a.length(); i++){
            if(search.charAt(i) != '.' && search.charAt(i) != a.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DesignADataStructureForStrings wordDictionary = new DesignADataStructureForStrings();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
