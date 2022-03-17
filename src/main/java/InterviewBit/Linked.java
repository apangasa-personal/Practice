package InterviewBit;

public class Linked {

    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static boolean findPrime(int num){
        if(num == 1)
            return false;
        for (int i = 2; i*i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ListNode solve(ListNode A) {
        ListNode temp = A;
        ListNode special = null, specialItr = special;
        ListNode other = null, otherItr = other;
        while (temp != null){
            int s = getSum(temp.val);
            if(findPrime(s)){
                if(special == null){
                    special = temp;
                    specialItr = special;
                }
                else {
                    specialItr.next = temp;
                    specialItr = specialItr.next;
                }
            }
            else{
                if(other == null){
                    other = temp;
                    otherItr = other;
                }
                else {
                    otherItr.next = temp;
                    otherItr = otherItr.next;
                }
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }
        specialItr.next = other;
        return special;
    }

    public static ListNode addNode(ListNode head, int v){
        head.next = new ListNode(v);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(67);
        ListNode temp = head;
        temp.next = new ListNode(70);
        temp = temp.next;
        temp.next = new ListNode(14);
        temp = temp.next;
        temp.next = new ListNode(61);
        temp = temp.next;
        temp.next = new ListNode(9);
        temp = temp.next;
        temp.next = new ListNode(57);
        temp = temp.next;
        temp.next = new ListNode(51);
        temp = temp.next;
        temp.next = new ListNode(26);
        temp = temp.next;
        temp.next = new ListNode(95);
        temp = temp.next;
        temp.next = new ListNode(36);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        solve(head);
    }
}
