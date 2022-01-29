package scaler;

import java.util.List;

public class Add2Numbers {

    //listnode class
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //core method that does addition
    public static ListNode addTwoNumbersCore(ListNode l1, ListNode l2) {
        //base condition
        if(l1 == null && l2 == null){
            return null;
        }
        //recursion
        addTwoNumbersCore(l1.next,l2.next);

        //create new node and process carry
        ListNode newNode = new ListNode((l1.val + l2.val + carry)%10);
        carry = (l1.val + l2.val + carry)/10;

        //insert in result
        if(result == null){
            result = newNode;
            return result;
        }
        else{
            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    //n1 and n2 to hold normalized result list. And result for result list
    static ListNode n1, n2, result;
    static int carry = 0;

    //adjust length of numbers to make is equal
    public static void normalizeNumbers(ListNode l1, ListNode l2){
        n1 = l1;
        n2 = l2;

        //move to next elements if both elements are not null
        while(l1 != null && l2 != null){
            l1 = l1.next; l2 = l2.next;
        }

        //adjust preceding 0s for n2
        while (l1 != null){
            ListNode newNode = new ListNode(0);
            newNode.next = n2;
            n2 = newNode;
            l1 = l1.next;
        }

        //adjust preceding 0s for n1
        while (l2 != null){
            ListNode newNode = new ListNode(0);
            newNode.next = n1;
            n1 = newNode;
            l2 = l2.next;
        }
    }

    //add 2 lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //normalize lists to add preceding 0s if length of numbers is not same
        normalizeNumbers(l1, l2);

        //add numbers
        l1 = addTwoNumbersCore(n1, n2);

        //adjust carry
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = l1;
            l1 = newNode;
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(7);
//        head.next.next.next = new ListNode(8);
        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(5);
        ListNode other = addTwoNumbers(head, head2);
        System.out.println("done");
    }
}
