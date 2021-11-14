package scaler;

import java.util.*;

public class Strings {
    public static String alterString(String str){
        int index = 0;
        StringBuilder temp = new StringBuilder();
        temp.append(str);
        while(index < temp.length()) {
            if (temp.charAt(index) > 64 && temp.charAt(index) < 91) {
                temp.deleteCharAt(index);
            } else if (temp.charAt(index) == 'a' || temp.charAt(index) == 'e' || temp.charAt(index) == 'i' || temp.charAt(index) == 'o' || temp.charAt(index) == 'u') {
                temp.replace(index,index+1,"#");
                index++;
            } else
                index++;
        }
        return temp.toString();
    }


    public static int magicStrings(String A){
        int result = 0;
        for(int i = 0; i< A.length(); i++){
            if(A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u' || A.charAt(i) == 'A' || A.charAt(i) == 'E' || A.charAt(i) == 'I' || A.charAt(i) == 'O' || A.charAt(i) == 'U' )
                result = result + A.length() - i;
        }
        return result%10003;
    }

    //longest prefix subarray
    public static String longestPrefix(String[] A){
        int i = 0, j= 1;
        char ch;
        if(A.length == 1)
            return A[0];
        for(; i< A[0].length(); i++) {
            ch = A[0].charAt(i);
            for(j=1; j< A.length; j++){
                if(A[j].charAt(i) != ch)
                    return A[0].substring(0,i);
                else if(A[j].charAt(i) == ch && A[j].length()-1 == i)
                    return A[0].substring(0,i+1);
            }
        }
        if(i==A[0].length() && j== A.length)
            return A[0].substring(0,i);
        return  "";
    }

    public static LinkedHashMap<Character, Integer> sortHashMapByValues(HashMap<Character, Integer> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Character, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Character> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Character key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    //distinct chars
    public static int distinctChars(String str, int B){
        HashMap<Character, Integer> elements = new HashMap<Character, Integer>();
        for(int i = 0; i< str.length(); i++){
            if(!elements.containsKey(str.charAt(i)))
                elements.put(str.charAt(i),1);
            else
                elements.put(str.charAt(i),elements.get(str.charAt(i)) + 1);
        }
        LinkedHashMap<Character, Integer> sortedMapAsc = sortHashMapByValues(elements);
        int result = sortedMapAsc.size();
        for(char key: sortedMapAsc.keySet()){
            B = B - sortedMapAsc.get(key);
            if(B >= 0){
                result--;
            }
            else
                break;
        }
        return result;
    }

    public static void main(String[] args){
        String A = "umeaylnlfd";
        int B = 1;
        System.out.println(distinctChars(A,B));
    }
}
