package scaler;

import java.util.*;

public class TrieQues {
    static class Trie{
        Boolean b;
        int pValue;
        ArrayList<Integer> weights = new ArrayList<>();
        HashMap<Character, Trie> map = new HashMap<>();
    }
    static Trie root = new Trie();
    public static int[] solve(String[] A, String[] B) {
        for(int i = 0; i< A.length; i++){
            Trie temp = root;
            for(int j = 0; j< A[i].length(); j++){
                if(temp.map.containsKey(A[i].charAt(j))){
                    temp = temp.map.get(A[i].charAt(j));
                }
                else{
                    temp.map.put(A[i].charAt(j), new Trie());
                    temp = temp.map.get(A[i].charAt(j));
                }

                if(j == A[i].length()- 1)
                    temp.b = true;

            }
        }
        int[] result = new int[B.length];
        for(int i = 0; i < result.length; i++){
            Trie temp = root;
            for(int j = 0; j< B[i].length(); j++){
                if(!temp.map.containsKey(B[i].charAt(j))) {
                    result[i] = 0;
                    break;
                }
                temp = temp.map.get(B[i].charAt(j));
                if(j == B[i].length() - 1){
                    if(temp.b != null)
                        result[i] = 1;
                }
            }
        }
        return result;
    }

    public static String[] prefix(String[] A) {
        for(int i = 0; i < A.length; i++){
            Trie temp = root;
            for(int j = 0; j< A[i].length(); j++){
                char ch = A[i].charAt(j);
                if(temp.map.containsKey(ch)){
                    temp.map.get(ch).pValue++;
                }
                else{
                    temp.map.put(ch, new Trie());
                    temp.map.get(ch).pValue = 1;
                }
                temp = temp.map.get(ch);
            }
        }
        String[] e = new String[A.length];
        for(int i = 0; i< A.length; i++){
            Trie temp = root;
            StringBuilder s = new StringBuilder();
            for(int j = 0; j< A[i].length(); j++) {
                char ch = A[i].charAt(j);
                s.append(ch);
                if(temp.map.get(ch).pValue == 1)
                    break;
                temp = temp.map.get(ch);
            }
            e[i] = s.toString();
        }
        return e;
    }

    static Trie wightedRoot = new Trie();
    public static String[][] solve(String[] a, String[] b, int[] weights){
        for(int i = 0; i< a.length; i++){
            Trie temp = wightedRoot;
            for(int j = 0; j< a[i].length(); j++){
                char ch = a[i].charAt(j);
                if(!temp.map.containsKey(ch)){
                    temp.map.put(ch, new Trie());
                }
                temp = temp.map.get(ch);
                if(j == a[i].length() - 1) {
                    temp.weights.add(weights[i]);
                }
            }
        }
        String[][] result = new String[b.length][];
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for(int i = 0; i< b.length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b[i]);
            Trie temp = wightedRoot;
            boolean prefixFound = true;
            for(int j = 0; j < b[i].length(); j++){
                char ch = b[i].charAt(j);
                if(temp.map.containsKey(ch))
                    temp = temp.map.get(ch);
                else{
                    prefixFound = false;
                    break;
                }
            }
            if(prefixFound){
                treeMap = findWords(temp, b[i], new TreeMap(), b[i]);
                Collection c = treeMap.values();
                Iterator itr = c.iterator();
                int ctr = 0;
                if(treeMap.size() > 5)
                    result[i] = new String[5];
                else
                    result[i] = new String[treeMap.size()];
                while(itr.hasNext() && treeMap.size() - ctr > 5) {
                    ctr++;
                    itr.next();
                }
                ctr= 0;
                while(itr.hasNext() && ctr < 5) {
                    result[i][ctr] = (String) itr.next();
                    ctr++;
                }
                for(int k=0; k<result[i].length/2; k++){
                    String v = result[i][k];
                    result[i][k] = result[i][result[i].length - k -1];
                    result[i][result[i].length - k -1] = v;
                }
            }
            else {
                result[i] = new String[1];
                result[i][0] = "-1";
            }
        }
        return result;
    }

    public static TreeMap findWords(Trie node, String s, TreeMap result, String prefix){
        if(node.weights.size() > 0){
            for (int i = 0; i < node.weights.size(); i++)
                result.put(node.weights.get(i), s);
        }
        if(node.map.keySet().size() == 0)
            return result;
       for(char ch : node.map.keySet()){
           findWords(node.map.get(ch),s+ch, result, prefix);
       }
       return result;
    }

    public static void main(String[] args) {
        String[] A = { "zebra", "dog", "duck", "dove" },
        B = { "a", "b", "ab", "abcd"};
//        prefix(A);
//        int[] a = solve(A,B);
        String[] one = {"bbd", "cbbdec", "eaedbcdd", "bbddc" ,"ccced", "ed", "aacdbac", "dbaae", "a", "bddedee", "abbbdee", "dcddceb", "aede", "c"};
        String[] two = {"a", "eaedbcd", "eaedb", "cbb", "ccced", "cbbd", "a", "ccce"};
        int[] v = {35 ,8 ,54 ,12 ,21 ,46 ,27 ,19 ,66 ,76 ,32 ,58 ,69 ,36};
        solve(one, two, v);
    }
}
