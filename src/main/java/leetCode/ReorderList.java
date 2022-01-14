package leetCode;

import java.util.List;

public class ReorderList {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static ListNode head;

    public static void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode temp = head;
        ListNode midParent = temp;
        while(temp != null && temp.next != null){
            midParent = mid;
            mid = mid.next;
            temp = temp.next.next;
        }
        mid = reverseList(mid);
        ListNode newHead = new ListNode();
        temp = new ListNode();
        ListNode midNext = new ListNode();
        ListNode headNext = new ListNode();
        newHead = head;
        headNext = head.next;
        temp = newHead;
        head = head.next;
        while(mid.next != null){
            midNext = mid.next;
            temp.next = mid;
            temp = temp.next;
            headNext = head.next;
            temp.next = head;
            temp = temp.next;
            head = headNext;
            mid = midNext;
        }
        if(midNext != null)
            temp.next = mid;
        head = newHead;
        System.out.println("done");
    }

    public static ListNode reverseList(ListNode curr) {
        ListNode end = null;
        while(curr!= null) {
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }
        return end;
    }
    public static void main(String[] rags){
        head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(3);
        temp.next.next.next = new ListNode(4);
        temp.next.next.next.next = new ListNode(5);
        reorderList(head);
        System.out.println("done");
    }
}
