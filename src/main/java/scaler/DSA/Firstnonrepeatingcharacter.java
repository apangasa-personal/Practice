package scaler.DSA;

import java.util.*;

public class Firstnonrepeatingcharacter {
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = (Queue<Character>) new LinkedList();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
           if(queue.isEmpty()) {
               queue.add(ch);
               map.put(ch, map.getOrDefault(ch, 0) + 1);
           }
           else{
               queue.add(ch);
               map.put(ch, map.getOrDefault(ch, 0) + 1);
               while (!queue.isEmpty() && map.get(queue.peek()) > 1)
                   queue.remove();
           }
           if(queue.isEmpty())
               sb.append("#");
           else
               sb.append(queue.peek());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl";
        System.out.println(solve(A));
    }
}
