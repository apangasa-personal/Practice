package scaler;

import java.util.List;

public class Kreverselinkedlist {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    int count = 0;
    public static ListNode reverseLinkedList(ListNode A) {
        if (A == null)
            return A;
        ListNode current = A, prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int solve(ListNode A) {
        ListNode slow = A, fast = A;
        if(A.next == null || A.next.next == null)
            return A.val;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }
        return slow.val;
    }


    public static ListNode reverseList(ListNode A, int B) {
        if (A == null)
            return A;
        int k = 0;
        ListNode current = A, prev = null, next = null;
        while(k < B && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k++;
        }
        A.next = reverseList(current, B);
        return prev;
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        int counter = 1;
        ListNode connectingNode1 = null, next, current = A, prev = null, connectingNode2 = null;
        while (counter < B){
            connectingNode1 = current;
            current = current.next;
            counter++;
        }
        if(B != 1)
            connectingNode2 = connectingNode1.next;
        while(counter <= C && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter++;
        }
        if(B == 1) {
            connectingNode2 = A;
            connectingNode2.next = current;
            return prev;
        }
        connectingNode2.next = current;
        connectingNode1.next = prev;
        return A;
    }

    public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        if(A == null || A.next == null)
            return A;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return A;
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null)
            return A;
        int total = 0;
        ListNode temp = A;
        while(temp != null){
            temp = temp.next;
            total++;
        }
        if(B >= total)
            return A.next;
        temp = A;
        for(; total > B + 1 ; total--)
            temp = temp.next;
        if(temp.next == null)
            temp = null;
        temp.next = temp.next.next;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next= new ListNode(4);
//        head.next.next.next.next= new ListNode(5);
//        head.next.next.next.next.next= new ListNode(5);
        ListNode result = removeNthFromEnd(head,1);
        System.out.println("done");
    }
}

