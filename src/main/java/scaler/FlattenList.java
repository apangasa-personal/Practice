package scaler;

public class FlattenList {
    static class Node {
        int data;
        Node next;
        Node down;
    }

    public static Node push(Node head, int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;
        newNode.down = head;

        return newNode;
    }

    public static Node createVerticalList(Node head, int[] arr) {
        for (int key : arr) {
            head = push(head, key);
        }
        return head;
    }

    public static Node sort(Node head){
        if(head == null || head.down == null)
            return head;
        Node slow = head, fast = head;
        while (fast.down != null && fast.down.down != null){
            slow = slow.down;
            fast = fast.down.down;
        }
        Node head1 = head;
        Node head2 = slow.down;
        slow.down = null;
        head1 = sort(head1);
        head2 = sort(head2);
        return merge(head1, head2);
    }

    public static Node merge(Node A, Node B) {
        Node C = null, temp = null;
        while (A != null && B != null){
            Node newNode;
            if(A.data < B.data){
                newNode = A;
                A = A.down;
            }
            else{
                newNode = B;
                B = B.down;
            }
            if(C == null){
                C = newNode;
                temp = C;
            }
            else{
                temp.down = newNode;
                temp = temp.down;
            }
        }

        if(A!= null){
            if(C == null){
                C = A;
            }
            else{
                temp.down = A;
            }
        }

        if(B!= null){
            if(C == null){
                C = B;
            }
            else{
                temp.down = B;
            }
        }
        return C;
    }

    public static Node flatten(Node head){
        Node temp = null, iteratorDown, nextIterator = head;
        while (nextIterator != null){
            iteratorDown = nextIterator;
            nextIterator = nextIterator.next;
            while(iteratorDown != null){
                if(temp == null)
                    temp = iteratorDown;
                else {
                    temp.down = iteratorDown;
                    temp = temp.down;
                }
                iteratorDown = iteratorDown.down;
                temp.down = null;
                temp.next = null;
            }
        }
        return head;
    }


    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.down;
        }

        System.out.println("null");
    }

    public static void main(String[] args)
    {
        Node head = null;

        int[] arr1 = { 8, 6, 4, 1 };
        int[] arr2 = { 7, 3, 2 };
        int[] arr3 = { 9, 5 };
        int[] arr4 = { 12, 11, 10 };

        head = createVerticalList(head, arr1);
        head.next = createVerticalList(head.next, arr2);
        head.next.next = createVerticalList(head.next.next, arr3);
        head.next.next.next = createVerticalList(head.next.next.next, arr4);

        // flatten the list
        flatten(head);

        // sort the list
        head = sort(head);

        // print the flattened and sorted linked list
        printList(head);
    }
}
