package scaler.DSA;

import java.util.LinkedHashMap;

public class LRUCacheLinkedList {
    public static class Solution {
        private int capacity;
        int consumed;
        private LinkedHashMap<Integer,Integer> map;
        public Solution(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
            this.consumed = 0;
        }

        public void set(int key, int value){
            if(map.containsKey(key)) {
                map.remove(key);
                consumed--;
            }
            if(consumed == capacity){
                map.remove(map.keySet().toArray()[0]);
                consumed--;
            }
            consumed++;
            map.put(key, value);
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return map.get(key);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(7);
        solution.set(2,1);
        solution.set(1,10);
        solution.set(8,13);
        System.out.println(solution.get(12));
        solution.set(2,8);
        System.out.println(solution.get(11));
        System.out.println(solution.get(7));
        solution.set(14,7);
        solution.set(12,9);
        solution.set(7,10);
        System.out.println(solution.get(11));
        solution.set(9,3);
        solution.set(14,15);
        System.out.println(solution.get(15));
        System.out.println(solution.get(9));
        solution.set(4,13);
        System.out.println(solution.get(3));
        solution.set(13,7);
        System.out.println(solution.get(2));
        solution.set(5,9);
        System.out.println(solution.get(6));
        System.out.println(solution.get(13));
        solution.set(4,5);
        solution.set(3,2);
        solution.set(4,12);
        System.out.println(solution.get(13));
        System.out.println(solution.get(7));
        solution.set(9,7);
        System.out.println(solution.get(3));
        System.out.println(solution.get(6));
        System.out.println(solution.get(2));
        solution.set(8,4);
        solution.set(8,9);
        solution.set(1,4);
        solution.set(2,9);
        solution.set(8,8);
        System.out.println(solution.get(13));
        System.out.println(solution.get(3));
        System.out.println(solution.get(13));
        System.out.println(solution.get(6));
        solution.set(3,8);
        System.out.println(solution.get(14));
        System.out.println(solution.get(4));
        solution.set(5,6);
        solution.set(10,15);
        System.out.println(solution.get(12));
        solution.set(13,5);
        solution.set(10,9);
        solution.set(3,12);
        solution.set(14,15);
        System.out.println(solution.get(4));
        solution.set(10,5);
        System.out.println(solution.get(5));
        System.out.println(solution.get(15));
        solution.set(7,6);
        System.out.println(solution.get(1));
        solution.set(5,12);
        solution.set(1,6);
        solution.set(11,8);
    }
}
