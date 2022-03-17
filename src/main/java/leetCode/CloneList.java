package leetCode;

import scaler.CopyList;

    public class CloneList {
        static class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }

        public static Node copyRandomList(Node head) {
            if(head == null)
                return null;
            Node newHead = head;
            Node temp = head;
            while(temp != null){
                Node tempNext = temp.next;
                temp.next = new Node(temp.val);
                temp.next.next = tempNext;
                temp = temp.next.next;
            }
            temp = newHead;
            while(temp != null){
                if(temp.random == null)
                    temp.next.random = null;
                else
                    temp.next.random = temp.random.next;
                temp = temp.next.next;
            }
            newHead = newHead.next;
            temp = newHead;
            while (temp.next.next != null){
                temp.next = temp.next.next;
                temp = temp.next;
            }
            return newHead;
        }

        public static void main(String[] args) {
            Node head = new Node(7);
            head.next = new Node(13);
            head.next.next = new Node(11);
            head.next.next.next = new Node(10);
            head.next.next.next.next = new Node(1);
            head.next.random = head;
            head.next.next.random = head.next.next.next.next;
            head.next.next.next.random = head.next.next;
            head.next.next.next.next.random = head;
            Node h = copyRandomList(head);
            System.out.println("done");
        }
}
