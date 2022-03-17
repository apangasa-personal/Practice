package InterviewBit;

public class MergeSortedList {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode() {};
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

    public static ListNode mergeSort(ListNode root){
        if(root == null || root.next == null)
            return root;
        ListNode slow = root, fast = root;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = root;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return solve(head1, head2);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, temp = null;
        for(int i = 0; i< lists.length; i++){
            if(lists[i] == null)
                continue;
            else {
                if(head == null){
                    head = lists[i];
                    temp = head;
                }
                else {
                    while (temp != null && temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = lists[i];
                }
            }
        }
        return mergeSort(head);
    }

    public static void main(String[] args) {
        //12 -> 22 -> 27 -> 29
        ListNode A = null;
//        A.next = new ListNode(22);
//        A.next.next = new ListNode(27);
//        A.next.next.next = new ListNode(29);

        //7 -> 12 -> 46 -> 66
        ListNode B = new ListNode(7);
        B.next = new ListNode(12);
        B.next.next = new ListNode(46);
        B.next.next.next = new ListNode(66);

        ListNode C = new ListNode(1);
        C.next = new ListNode(2);
        C.next.next = new ListNode(15);
        C.next.next.next = new ListNode(60);
        ListNode[] nodes = new ListNode[]{A,B,C};

        ListNode D = mergeKLists(nodes);
        System.out.println("done");
    }
}
