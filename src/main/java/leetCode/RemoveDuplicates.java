package leetCode;

import InterviewBit.Linked;

public class RemoveDuplicates {

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nhead = null, prev = null, current = head, next = head.next;
        while(current != null){
           while(next != null && current.val == next.val){
               current = next;
               next = current.next;
           }
           if(prev == null) {
               prev = current;
               nhead = prev;
           }
           else {
               prev.next = current.next;
               prev = prev.next;
           }
           current = prev.next;
           next = current.next;
        }
        return nhead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(listNode);
    }

}
