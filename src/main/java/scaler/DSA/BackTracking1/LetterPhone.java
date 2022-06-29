package scaler.DSA.BackTracking1;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {

    static HashMap<Character, Character[]> values;

    public static ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();
        values = new HashMap<>();
        values.put('2', new Character[]{'a','b','c'});
        values.put('3', new Character[]{'d','e','f'});
        values.put('4', new Character[]{'g','h','i'});
        values.put('5', new Character[]{'j','k','l'});
        values.put('6', new Character[]{'m','n','o'});
        values.put('7', new Character[]{'p','q','r','s'});
        values.put('8', new Character[]{'t','u','v'});
        values.put('9', new Character[]{'w','x','y', 'z'});
        letterCombinations(A, "", 0, result);
        return result;
    }

    public static void letterCombinations(String A, String currentString, int index, ArrayList<String> result) {
        if(index == A.length()){
            result.add(currentString);
            return;
        }
        if(A.charAt(index) == '0' || A.charAt(index) == '1') {
            letterCombinations(A, currentString + A.charAt(index), index + 1, result);
        }
        else{
            for(char charValue : values.get(A.charAt(index))){
                letterCombinations(A, currentString + charValue, index + 1, result);
            }
        }
        return;
    }


    public static void main(String[] args) {
        String A = "23";
        ArrayList<String> result = letterCombinations(A);
        System.out.println("don");
    }
}
