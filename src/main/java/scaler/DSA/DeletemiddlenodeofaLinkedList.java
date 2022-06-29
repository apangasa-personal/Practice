package scaler.DSA;

public class DeletemiddlenodeofaLinkedList {
     static class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
   }
    public static ListNode solve(ListNode A) {
         if(A== null)
             return null;

         ListNode slow = A, fast = A, slowParent = slow;
         if(fast.next == null || fast.next.next == null)
            return slow.next;
         while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slowParent = slow;
            slow = slow.next;

        }
         if(fast.next == null)
            slowParent.next = slowParent.next.next;
         else
             slow.next = slow.next.next;
        return A;
    }
    //1->2->3->4->5
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
//        head.next.next.next.next.next= new ListNode(6);
        ListNode result = solve(head);
        System.out.println("done");
    }
}
