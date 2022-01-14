package leetCode;

import java.util.List;

public class SwapNodesinPairs {

     public static class ListNode {
     int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head, parent = null, next = null, nextnext = null;
        if(head == null || head.next == null)
            return head;
        while(temp != null){
            if(temp.next == null)
                return head;
            nextnext = temp.next.next;
            next = temp.next;
            next.next = temp;
            temp.next = nextnext;

            if(parent == null)
                head = next;
            parent = temp;
            temp = parent.next;
            next = parent.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = swapPairs(head);
    }
}
