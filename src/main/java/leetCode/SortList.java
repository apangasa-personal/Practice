package leetCode;

public class SortList {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        ListNode newNode = null;
        if(head1.val > head2.val){
            newNode = head2;
            head2 = head2.next;
        }
        else{
            newNode = head1;
            head1 = head1.next;
        }
        ListNode root = newNode;
        while(head1 != null && head2 != null){
            if(head1.val > head2.val){
                newNode.next = head2;
                head2 = head2.next;
            }
            else{
                newNode.next = head1;
                head1 = head1.next;
            }
            newNode = newNode.next;
        }
        if(head1 != null)
            newNode.next = head1;
        if(head2 != null)
            newNode.next = head2;
        return root;
    }

    public static ListNode sortList(ListNode head) {
        if(head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = sortList(head1);
        head2 = sortList(head2);
        ListNode newHead = merge(head1, head2);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode r = sortList(node);
    }

}
