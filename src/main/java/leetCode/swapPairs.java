package leetCode;

import java.util.List;

public class swapPairs {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode swapPairs(ListNode node) {
        if(node == null)
            return null;
        if(node.next == null)
            return node;

        ListNode myNextNext = null;
        if(node.next != null && node.next.next != null)
            myNextNext = swapPairs(node.next.next);
        ListNode temp = node.next;
        temp.next = node;
        node.next = myNextNext;
        return temp;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        swapPairs(root);
    }
}
