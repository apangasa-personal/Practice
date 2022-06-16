package leetCode;

import java.util.HashMap;

public class LFUCache {
    // frequency: linkedList
    HashMap<Integer, DoubleLinkedList> linkedListmap;

    //frequency : node
    HashMap<Integer, Node> frequencyMap;

    //frequency : count of Nodes
    HashMap<Integer, Integer> nodeCounts;
    int capacity, count;

    public void add(int key, int value){
        //0. create node
        Node newNode = new Node(key, value, null, null);
        if(!linkedListmap.containsKey(value)){
            linkedListmap.put(value, new DoubleLinkedList(new Node(-1,0,null,null), new Node(-1,0,null, null)));
        }
        //1. update doubly linked list map
        DoubleLinkedList doubleLinkedList = linkedListmap.get(value);
        Node tail = doubleLinkedList.tail;
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;

        //2. update frequncy map
        frequencyMap.put(key, newNode);

        //3. update node counts

        nodeCounts.put(value, nodeCounts.getOrDefault(value,2) + 1);

        //4. update count
        count++;
    }

    public void removeNode(Node node){
        //0. remove node
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //1. update node count
        nodeCounts.put(node.frequency, nodeCounts.get(node.frequency) - 1);
        if(nodeCounts.get(node.frequency) == 2)
            nodeCounts.remove(node.frequency);

        //2. update frequency map
        frequencyMap.remove(node.value);

        //3. update doublyLinkedList map if required
        if(!nodeCounts.containsKey(node.frequency))
            linkedListmap.remove(node.frequency);

        //update count
        count--;
    }

    public void removeFirst(){
        //1. remove element from doublyLinkedList
        int key = (int) linkedListmap.keySet().toArray()[0];
        Node node = linkedListmap.get(key).head.next;
        Node head = linkedListmap.get(key).head;
        head.next = node.next;
        node.next.prev = head;

        //2. update node counts
        nodeCounts.put(key, nodeCounts.get(key) - 1);

        //3. if no more nodes, remove entry from nodeCounts and linkedListmap
        if(nodeCounts.get(key) == 2) {
            nodeCounts.remove(key);
            linkedListmap.remove(key);
        }

        //update frequency map
        frequencyMap.remove(node.value);
    }

    class DoubleLinkedList{
        Node head, tail;

        public DoubleLinkedList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
            head.next = tail;
            tail.prev = head;
        }
    }
    class Node {
        int value, frequency;
        Node next, prev;
        public Node(int value, int frequency, Node next, Node prev) {
            this.value = value;
            this.frequency = frequency;
            this.next = next;
            this.prev = prev;
        }
    }
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        frequencyMap = new HashMap<>();
        linkedListmap = new HashMap<>();
        nodeCounts = new HashMap<>();
    }

    public int get(int key) {
        if(!frequencyMap.containsKey(key))
            return -1;

        //1. get new frequency
        int value = frequencyMap.get(key).frequency + 1;

        //2. update frequencyMap
        removeNode(frequencyMap.get(key));
        add(key, value);
        return key;
    }


    public void put(int key, int value) {
        if(frequencyMap.containsKey(key)){
            //1. get new frequency
            value = frequencyMap.get(key).frequency + 1;

            //2. update frequencyMap
            removeNode(frequencyMap.get(key));
            add(key, value);
        }
        else {
            if(count == capacity)
                removeFirst();
            add(key, 1);
        }
    }


    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);

    }
}
