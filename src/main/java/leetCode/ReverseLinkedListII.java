package leetCode;

import java.io.Flushable;

public class ReverseLinkedListII {
    private static ListNode head;

    public static class ListNode{
        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }

    public static ListNode reverse(ListNode current, int end){
        ListNode prev = null, next = null;
        int start = 0;
        while(current != null && start < end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            start++;
        }
        return prev;
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        ListNode current = head;
        ListNode currentParent = null;
        ListNode endNode = head;
        int start = 1;
        while(start < left){
            currentParent = current;
            current = current.next;
            start++;
        }
        start = 1;
        while(start <= right){
            endNode = endNode.next;
            start++;
        }
        ListNode result = reverse(current, right - left + 1);
        ListNode newListEnd = result;
        while(newListEnd.next != null)
            newListEnd = newListEnd.next;
        newListEnd.next = endNode;
        if(currentParent == null)
            head = result;
        else
            currentParent.next = result;
        return head;
    }

    public static void main(String[] args) {
        head = new ListNode();
        ListNode temp = head;
        temp.val = 3;
        temp.next = new ListNode(5);
//        temp.next.next = new ListNode(3);
//        temp.next.next.next = new ListNode(4);
//        temp.next.next.next.next = new ListNode(5);

        temp.next.next = reverseBetween(head, 1,2);
        System.out.println("done");
    }
}
