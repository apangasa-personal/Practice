package InterviewBit;

public class RemoveNthNodefromListEnd {
    static class ListNode {
         public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static class Solution {
        public static ListNode removeNthFromEnd(ListNode A, int B) {
            if(A == null)
                return null;
            ListNode temp = A; int count = 0;
            while(temp!= null){
                temp = temp.next;
                count++;
            }
            if (count < B)
                return A;
            if(count == B)
                return A.next;
            else {
                count = count - (B +1);
                temp = A;
                while(count > 0 ){
                    temp = temp.next;
                    count--;
                }
                if(temp.next != null)
                    temp.next = temp.next.next;
            }
            return A;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            head = removeNthFromEnd(head, 2);
            System.out.println("done");
        }
    }
}
