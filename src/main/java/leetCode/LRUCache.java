package leetCode;

import java.util.HashMap;

public class LRUCache {
    public class Node{
        int value;
        int time;
        Node next, prev;

        public Node(int value, int time, Node next, Node prev) {
            this.value = value;
            this.time = time;
            this.next = next;
            this.prev = prev;
        }
    }

    int capacity, count;
    Node head, tail;
    HashMap<Integer, Node> cacheEntries;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node(-1, 0, null, null);
        tail = new Node(-1, 0, null, null);
        head.next = tail;
        tail.prev = head;
        cacheEntries = new HashMap<>();
    }

    public int get(int key) {
        if(!cacheEntries.containsKey(key))
            return -1;
        Node entry = cacheEntries.get(key);
        removeElement(entry);
        addElement(entry.value, entry.time);
        return entry.time;
    }

    public void put(int key, int value) {
        if(cacheEntries.containsKey(key)){
            removeElement(cacheEntries.get(key));
            addElement(key, value);
            return;
        }
        if(capacity == count){
            removeFirst();
        }
        addElement(key, value);
    }

    public void removeFirst(){
        Node node = head.next;
        head.next = node.next;
        node.next.prev = head;
        cacheEntries.remove(node.value);
        node = null;
    }

    public void addElement(int key, int value){
        Node newNode = new Node(key, value, null, null);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        cacheEntries.put(key, newNode);
    }

    public void removeElement(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

