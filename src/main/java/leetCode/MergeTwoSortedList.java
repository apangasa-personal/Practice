package leetCode;

import scaler.LinkedList;

public class MergeTwoSortedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode start = null, temp = null, A = list1, B = list2, Anext, Bnext;
        while (A != null && B != null){
            if(start == null){
                if(A.val < B.val){
                    Anext = A.next;
                    start = A;
                    A = Anext;
                }
                else {
                    Bnext = B.next;
                    start = B;
                    B = Bnext;
                }
                temp = start;
            }
            else{
                if(A.val < B.val){
                    Anext = A.next;
                    temp.next = A;
                    A = Anext;
                }
                else {
                    Bnext = B.next;
                    temp.next = B;
                    B = Bnext;
                }
                temp = temp.next;
            }
        }
        if(A!= null)
            temp.next = A;
        if(B!= null)
            temp.next = B;
        return start;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        mergeTwoLists(l, l1);
    }
}
