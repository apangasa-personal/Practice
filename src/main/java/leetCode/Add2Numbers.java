package leetCode;

import java.util.Stack;

public class Add2Numbers {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
  }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();
        while(l1!= null){
            l1Stack.push(l1);
            l1 = l1.next;
        }

        while(l2!= null){
            l2Stack.push(l2);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int carry = 0;
        while(l1Stack.size() > 0 && l2Stack.size() > 0){
            ListNode l1Current = l1Stack.pop();
            ListNode l2Current = l2Stack.pop();
            ListNode current = new ListNode((l1Current.val + l2Current.val + carry)%10);
            carry = (l1Current.val + l2Current.val + carry)/10;
            if(head.next != null)
                current.next = head.next;
            head.next = current;
        }
        while(l1Stack.size() > 0){
            ListNode l1Current = l1Stack.pop();
            ListNode current = new ListNode((l1Current.val + carry)%10);
            carry = (l1Current.val + carry)/10;
            if(head.next != null)
                current.next = head.next;
            head.next = current;
        }
        while(l2Stack.size() > 0){
            ListNode l2Current = l2Stack.pop();
            ListNode current = new ListNode((l2Current.val + carry)%10);
            if(head.next != null)
                current.next = head.next;
            head.next = current;
        }
        if(carry != 0){
            ListNode current = new ListNode(carry);
            current.next = head;
            head = current;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        addTwoNumbers(listNode1, listNode2);
    }
}
