package InterviewBit;

public class MergeSortedList {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static ListNode solve(ListNode A, ListNode B){
        if(A== null && B== null)
            return null;
        ListNode start;
        if(A.val <= B.val){
            start = new ListNode(A.val);
            A = A.next;
        }

        else{
            start = new ListNode(B.val);
            B = B.next;
        }
        ListNode temp = start;
        while(A!= null && B!= null){
            if(A.val <= B.val){
                temp.next = new ListNode(A.val);
                A = A.next;
            }
            else{
                temp.next = new ListNode(B.val);
                B = B.next;
            }
            temp = temp.next;
        }
        while(A!= null){
            temp.next = new ListNode(A.val);
            A = A.next;
            temp = temp.next;
        }
        while(B!= null){
            temp.next = new ListNode(B.val);
            B = B.next;
            temp = temp.next;
        }
        return start;
    }

    public static void main(String[] args) {
        //12 -> 22 -> 27 -> 29
        ListNode A = new ListNode(12);
        A.next = new ListNode(22);
        A.next.next = new ListNode(27);
        A.next.next.next = new ListNode(29);

        //7 -> 12 -> 46 -> 66
        ListNode B = new ListNode(7);
        B.next = new ListNode(12);
        B.next.next = new ListNode(46);
        B.next.next.next = new ListNode(66);

        ListNode C = solve(A,B);
        System.out.println("done");
    }
}
