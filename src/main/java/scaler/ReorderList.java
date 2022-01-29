package scaler;

public class ReorderList {

  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static ListNode reverse(ListNode A) {
    ListNode prev = null, current = A, next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public static ListNode reorderList(ListNode A) {
    ListNode slow = A, fast = A;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode reversed = reverse(slow.next);
    slow.next = null;
    slow = A;
    while (reversed != null) {
      ListNode revsersedNext = reversed.next;
      fast = slow.next;
      slow.next = reversed;
      reversed.next = fast;
      reversed = revsersedNext;
      slow = fast;
    }
    return A;
  }

  public static ListNode swapPairs(ListNode A) {
    if (A == null || A.next == null)
      return A;
    ListNode prev = null, current = A, next;
    int i = 1;
    while (current != null && i <= 2) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      i++;
    }
    A.next = swapPairs(current);
    return prev;
  }

  public static int lPalin(ListNode A) {
    ListNode slow = A, fast = A;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode head1 = A;
    ListNode head2 = slow.next;
    slow.next = null;
    ListNode prev = null, current = head2, next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head2 = prev;
    while (head2 != null) {
      if (head1.val != head2.val)
        return 0;
      head1 = head1.next;
      head2 = head2.next;
    }
    return 1;
  }

  public static ListNode addTwoNumbers(ListNode A, ListNode B) {
      if (A == null && B == null)
        return null;
      ListNode head = null, temp = null;
      int carry = 0;
      while (A != null && B != null) {
        int val = A.val + B.val + carry;
        carry = val/10;
        val = val%10;
        ListNode newNode = new ListNode(val);
        if (head == null) {
          head = newNode;
          temp = head;
        } else {
          temp.next = newNode;
          temp = temp.next;
        }
        A = A.next;
        B = B.next;
      }
      while (A != null) {
        int val = A.val + carry;
        carry = val/10;
        val = val%10;
        ListNode newNode = new ListNode(val);
        if (head == null) {
          head = newNode;
          temp = head;
        } else {
          temp.next = newNode;
          temp = temp.next;
        }
        A = A.next;
      }
      while (B != null) {
        int val = B.val + carry;
        carry = val/10;
        val = val%10;
        ListNode newNode = new ListNode(val);
        if (head == null) {
          head = newNode;
          temp = head;
        } else {
          temp.next = newNode;
          temp = temp.next;
        }
        B = B.next;
      }
      if(carry == 1){
        temp.next = new ListNode(1);
      }
      return head;
    }

    public static ListNode sortList(ListNode A) {
      if(A == null || A.next == null)
        return A;
      ListNode slow = A, fast = A;
      while (fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }
      ListNode head1 = A;
      ListNode head2 = slow.next;
      slow.next = null;
      head1 = sortList(head1);
      head2 = sortList(head2);
      return merge(head1, head2);
    }

  public static ListNode merge(ListNode A, ListNode B) {
    ListNode newHead = null, temp = null;
    while (A != null && B!=null){
      ListNode newNode;
      if(A.val < B.val){
        newNode = new ListNode(A.val);
        A = A.next;
      }
      else {
        newNode = new ListNode(B.val);
        B = B.next;
      }
      if(newHead == null){
        newHead = newNode;
        temp = newHead;
      }
      else{
        temp.next = newNode;
        temp = temp.next;
      }
    }
    while (A != null){
      ListNode newNode = new ListNode(A.val);
      A = A.next;
      if(newHead == null){
        newHead = newNode;
        temp = newHead;
      }
      else{
        temp.next = newNode;
        temp = temp.next;
      }
    }
    while (B != null){
      ListNode newNode = new ListNode(B.val);
      B = B.next;
      if(newHead == null){
        newHead = newNode;
        temp = newHead;
      }
      else{
        temp.next = newNode;
        temp = temp.next;
      }
    }
    return newHead;
  }

  public static ListNode cloneList(ListNode A) {
    if(A == null)
      return null;
    ListNode temp = null;
    ListNode other = null;
    while (A != null){
      ListNode newNode = new ListNode(A.val);
      if(other == null) {
        temp = newNode;
        other = temp;
      }
      else{
        temp.next = newNode;
        temp = temp.next;
      }
      A = A.next;
    }
    return other;
  }
  static ListNode C;

//9 8 1 4
// 2 4
  static ListNode c;
  static int carry = 0;
  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0);
    if(l1.next != null && l2.next != null){
      node = addTwoNumbers2(l1.next, l2.next);
    }
    else if(l1.next != null){
      node = addTwoNumbers2(l1.next, l2);
    }
    else if(l2.next != null){
      node = addTwoNumbers2( l1, l2.next);
    }
    int val = (l1.val + l2.val) +carry;
    node.val = val%10;
    carry = val/10;
    return node;
  }


    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(2);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        ListNode result = addTwoNumbers(head, head2);
//      ListNode sorted = sortList(head);
      ListNode other = addTwoNumbers2(head, head2);
      System.out.println("done");
    }
}
