package InterviewBit;

public class ElementTowardsBeginning {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static int solve(ListNode A, int B) {

        ListNode slow = A, fast = A;
        int count = 0;
        while(slow != null){
            count++;
            slow = slow.next;
        }
        int mid = count/2 + 1;
        int element = mid - B;
        if(element <= 0)
            return -1;

        int i = 1;
        while(i < element){
            fast = fast.next;
            i++;
        }
        return fast.val;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(468);
        test.next = new ListNode(365);
        solve(test, 1);
    }

}
