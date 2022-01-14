package scaler;

public class DesignLinkedlist {

    static ListNode head;

    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int d)
        {
            val = d;
            next = null;
        }
    }

    public static void insertAtBeg(int value){
        ListNode newListNode = new ListNode(value);
        if(head == null) {
            head = newListNode;
            return;
        }
        newListNode.next = head;
        head = newListNode;
    }

    public static void insertAtEnd(int value){
        ListNode newListNode = new ListNode(value);
        if(head == null) {
            head = newListNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = newListNode;
    }

    public static void insertAtPos(int value, int pos){
        ListNode temp = new ListNode(value);
        ListNode start = head;
        int current = 0;

        if(head == null || pos == 0){
            temp.next = head;
            head = temp;
            return;
        }
        while(current+1 < pos && start.next != null){
            start = start.next;
            current++;
        }
        if(start != null){
            temp.next = start.next;
            start.next = temp;
        }
    }

    public static void deleteAtPos(int pos){
        if(pos == 0) {
            head = head.next;
            return;
        }
        if(head == null) {
            return;
        }
        ListNode temp = head;
        int current = 0;
        while(temp.next != null && current +1 < pos) {
            temp = temp.next;
            current++;
        }
        if(current +1 != pos)
            return;
        temp.next = temp.next.next;
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = head;
        int i = 0;
        while(temp != null){
            if(i!=0 )
                System.out.print(" ");
            System.out.print(temp.val);
            temp = temp.next;
            i++;
        }
    }

    public static ListNode solve(int[][] A) {
        for(int i = 0; i< A.length; i++){
            print_ll();
            System.out.println("\n");
            if(A[i][0] == 0)
                insertAtBeg(A[i][1]);
            else if (A[i][0] == 1)
                insertAtEnd(A[i][1]);
            else if(A[i][0] == 2)
                insertAtPos(A[i][1], A[i][2]);
            else if(A[i][0] == 3)
                deleteAtPos(A[i][1]);
        }
        print_ll();
        return head;
    }

    public static void main(String[] args){
        int[][] A = {{3, 1, -1},//null
                {3, 1, -1},//null
                {1, 18, -1},//18
                {2, 12, 1},//18,12
                {1, 17, -1},//18,12,17
                {2, 11, 3},//18,12,17,11
                {1, 19, -1},//18,12,17,11,19
                {3, 0, -1},//12,17,11,19
                {0, 12, -1}};//12,12,17,11,19
        //12 -> 12 -> 17 -> 11 -> 19
        solve(A);
    }
}
