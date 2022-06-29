package scaler.DSA;

import java.util.HashMap;
import java.util.List;

public class LRUCache {
    public static class Solution {
        int capacity = 0, consumed = 0;
        HashMap<Integer, ListNode> hashMap;
        public Solution(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>();
            head = null;
            tail = null;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            tail.prev = head;
            head.next = tail;
        }

        public int get(int key) {
            if(hashMap.containsKey(key)) {
                ListNode node = hashMap.get(key);
                remove(node);
                add(node);
                hashMap.put(key, node);
                return hashMap.get(key).val;
            }

            return -1;
        }

        public void remove(ListNode temp){
            Object[] keyset = hashMap.keySet().toArray();
            for(Object key: keyset)
                if(hashMap.get(key) == temp)
                    hashMap.remove(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        public void add(ListNode node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }

        public void set(int key, int value) {
            int val;
            if(hashMap.containsKey(key))
                val = 1;
            else
                val = -1;
            if(val != -1){
                ListNode node = hashMap.get(key);
                remove(node);
                consumed--;
            }
            else if(consumed == capacity){
                ListNode node = head.next;
                remove(node);
                consumed--;
            }
            ListNode node = new ListNode(value);
            add(node);
            hashMap.put(key, node);
            consumed++;
        }

        ListNode head, tail;
        public class ListNode{
            int val;
            ListNode next;
            ListNode prev;
            public ListNode(int val) {
                this.val = val;
            }
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
