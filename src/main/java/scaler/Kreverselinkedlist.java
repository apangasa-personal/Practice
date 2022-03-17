package scaler;

import java.util.ArrayList;
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

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null)
            return B;
        if(B == null)
            return A;
       ListNode c = null, temp = null;
       while (A != null && B != null){
           ListNode newNode;
           if(A.val < B.val){
               newNode = A;
               A = A.next;
           }
           else {
               newNode = B;
               B = B.next;
           }
           if(c == null){
               c = newNode;
               temp = c;
           }
           else{
               temp.next = newNode;
               temp = temp.next;
           }
       }
       if(A != null)
           temp.next = A;
       if(B != null)
           temp.next = B;
       return c;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode result = a.get(0);
        for(int i = 1; i< a.size(); i++){
            ListNode lN1 = a.get(i);
            result = mergeTwoLists(result, lN1);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(13);
        head.next.next.next= new ListNode(24);
        head.next.next.next.next= new ListNode(27);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(15);
        head2.next.next.next = new ListNode(16);
        head2.next.next.next.next = new ListNode(28);
        head2.next.next.next.next.next= new ListNode(29);
        //ListNode result = mergeTwoLists(head,head2);
        ListNode head3 = new ListNode(0);
        head3.next = new ListNode(4);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head); list.add(head2); list.add(head3);
        ListNode c = mergeKLists(list);
        System.out.println("done");
    }
}

