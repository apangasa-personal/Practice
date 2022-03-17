package scaler;

import java.util.HashMap;

public class ModifiedSearch {

    static class Trie{
        HashMap<Character, Trie> next = new HashMap<>();
        boolean end;
    }

    static Trie root = new Trie();

    public static void insertInTrie(String s){
        Trie temp = root;
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!temp.next.containsKey(ch))
                temp.next.put(ch, new Trie());
            temp = temp.next.get(ch);
        }
        temp.end = true;
    }

    public static String search(String s, Trie temp, int chancesLeft){
        if(s.length() == 1){
            if(chancesLeft == 0){
                if(temp.next.containsKey(s.charAt(0)) && temp.next.get(s.charAt(0)).end){
                    return "1";
                }
            }
            else{
                for(Character key : temp.next.keySet()){
                    if(key != s.charAt(0) && temp.next.get(key).end)
                        return "1";
                }
            }
            return "0";
        }

        if(chancesLeft < 0)
            return "0";
        String result = "0";
        for(Character key: temp.next.keySet()){
            if(key == s.charAt(0))
                result = search(s.substring(1), temp.next.get(key), chancesLeft);
            else
                result = search(s.substring(1), temp.next.get(key), chancesLeft - 1);
            if(result == "1")
                return result;
        }
        return result;
    }

    public static String solve(String[] A, String[] B) {
        for(int i = 0; i< A.length; i++)
            insertInTrie(A[i]);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < B.length; i++){
            sb.append(search(B[i], root, 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] A =  {"data", "circle", "cricket"}, B = {"date", "circel", "crikket", "data", "circl"};
        System.out.println(solve(A,B));
    }
}
