package InterviewBit;

import leetCode.ReverseLinkedListII;

public class EvenReverse {
    static class ListNode {
         public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
    }

    static ListNode head;

    public static ListNode reverse(ListNode current){
        ListNode prev = null, next = null;
        int start = 0;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode solve(ListNode A) {
        ListNode temp = A;
        ListNode oddHead = A;
        ListNode oddTemp = oddHead;
        ListNode evenHead = null;
        ListNode evenTemp = evenHead;
        boolean even = true;
        if(temp.next != null)
            temp = temp.next;

        while(temp != null) {
            if(even){
                if(evenHead == null){
                    evenHead = temp;
                    evenTemp = evenHead;
                }
                else{
                    evenTemp.next = temp;
                    evenTemp = evenTemp.next;
                }
            }
            else{
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
            even = !even;
        }
        oddTemp.next = null;
        evenTemp.next = null;
        evenHead = reverse(evenHead);
        A = oddHead;
        temp = A;
        oddTemp = oddHead;
        oddTemp = oddTemp.next;
        evenTemp = evenHead;
        even = true;
        while(oddTemp != null || evenTemp != null){
            if(even){
                temp.next = evenTemp;
                evenTemp = evenTemp.next;
            }
            else{
                temp.next = oddTemp;
                oddTemp = oddTemp.next;
            }
            even = !even;
            temp = temp.next;
        }

        return A;
    }

    public static void main(String[] args) {
        head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(3);
        temp.next.next.next = new ListNode(4);
        solve(head);
    }
}
