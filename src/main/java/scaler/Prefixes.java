package scaler;

import java.util.HashMap;

public class Prefixes {
    static class Trie{
        HashMap<Character, Trie> map = new HashMap<>();
        int count;
    }
    static Trie root = new Trie();

    public static int[] solve(int[] B, String[] A) {
        int oneCount = 0;
        for(int i = 0; i< A.length; i++){
            if(B[i] == 0){
                Trie temp = root;
                for(int j = 0; j < A[i].length(); j++){
                    char ch = A[i].charAt(j);
                    if(!temp.map.containsKey(ch)){
                        temp.map.put(ch, new Trie());
                    }
                    temp = temp.map.get(ch);
                    temp.count++;
                }
            }
            else
                oneCount++;
        }
        int[] r = new int[oneCount];
        for(int i = 0, j = 0; i< A.length; i++){
            if(B[i] == 1){
                Trie temp = root;
                Boolean found = true;
                for(int k = 0; k < A[i].length(); k++){
                    char ch = A[i].charAt(k);
                    if(temp.map.containsKey(ch))
                        temp = temp.map.get(ch);
                    else{
                        found = false;
                        break;
                    }
                }
                if(found)
                    r[j] = temp.count;
                j++;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1};
        String[] B = {"hack", "hacker", "hac", "hak"};
        solve(A,B);
    }
}
