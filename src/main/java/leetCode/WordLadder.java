package leetCode;

import java.util.*;

public class WordLadder {
    public static int wordMatch(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff;
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordList){
            set.add(str);
        }
        if(!set.contains(endWord))
            return 0;
        Collections.reverse(wordList);
        int result = 0;
        boolean foundendword = false;
        for(int i = 0; i< wordList.size(); i++){
            if(foundendword == false){
                if(wordList.get(i) == endWord){
                    foundendword = true;
                    result = 1;
                }
                continue;
            }
            String w = wordList.get(i);
            result++;
            for(int j= 0; j< wordList.get(i).length(); j++){
                if(wordMatch(w, beginWord) == 1)
                    return result;
            }

            if(i > 0 && wordMatch(w, wordList.get(i-1)) == 1)
                result--;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "ymain", endWord = "oecij";
        String[] arr = {"ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, arr);
        System.out.println(ladderLength(beginWord, endWord, wordList));

    }
}
