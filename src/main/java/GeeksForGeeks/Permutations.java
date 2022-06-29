package GeeksForGeeks;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        String s = "ABC";
        find_permutation(s);
    }
    public static List<String> find_permutation(String S) {
        // Code here
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        HashSet<String> result = new HashSet<>();

        find_permutation(charArray, 0, result, "");
        for(String s : result)
            System.out.println(s);
        List<String> r = new ArrayList<>();
        for(String s : result)
            r.add(s);
        Collections.sort(r);
        return r;

    }

    public static void find_permutation(char[] charArray, int i, HashSet<String> result, String current) {
        // Code here
        if(i == charArray.length - 1){
            current += charArray[i];
            result.add(new String(current));
            return;
        }
        for(int j = i+1; j < charArray.length; j++){
            String updatedString = current + charArray[i];
            find_permutation(charArray, i+1, result, updatedString);
            char temp = charArray[j];
            charArray[j] = charArray[i];
            charArray[i] = temp;

            updatedString = current + charArray[i];
            find_permutation(charArray, i+1, result,  updatedString);

            temp = charArray[j];
            charArray[j] = charArray[i];
            charArray[i] = temp;
        }

    }
}
