package scaler;

import java.util.HashMap;

public class ValidPhoneDirectory {

    static class  Trie{
        HashMap<Character, Trie> next = new HashMap<>();
        boolean ending = false;
    }

    static Trie root = new Trie();
    public static int solve(String[] A) {
        for(int i = 0; i < A.length; i++){
            Trie temp = root;
            for(int j = 0; j< A[i].length(); j++){
                char ch = A[i].charAt(j);
                if(temp.next.containsKey(ch))
                    temp = temp.next.get(ch);
                else{
                    temp.next.put(ch, new Trie());
                    temp = temp.next.get(ch);
                }
            }

            if(temp.next.size() != 0 || temp.ending == true)
                return 0;
            temp.ending = true;
        }
        return 1;
    }

    public static void main(String[] args) {
        String [] A = {"5678", "5678"};
        System.out.println(solve(A));
    }
}
