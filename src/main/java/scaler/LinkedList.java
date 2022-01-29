package scaler;

public class LinkedList {
    static Node head;

    static class Node
    {
        int value;
        Node next;
        Node(int d)
        {
            value = d;
            next = null;
        }
    }

    public static void insert_node(int position, int value) {
        Node temp = new Node(value);
        Node start = head;
        int current = 1;
        if(head == null){
            head = temp;
            head.next = null;
            return;
        }
        while(current+1 != position && start != null){
            start = start.next;
            current++;
        }
        if(start != null){
            temp.next = start.next;
            start.next = temp;
        }

    }

    public static void delete_node(int position) {
        // @params position, integer
        Node start = head;
        while(position!= 2 && start != null){
            start = start.next;
            position--;
        }
        if(start!= null)
            start.next = start.next.next;
    }

    public static void delete_nodeNew(int position) {
        Node temp = head;
        if (head == null)
            return;

        Node start = head;
        if (position == 0) {
            head = temp.next;   // Change head
            return;
        }
        for (int i=1; temp!=null && i<position-1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;  //
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(i!=0 )
                System.out.print(" ");
            System.out.print(temp.value);
            temp = temp.next;
            i++;
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }


    public static void main(String[] args){
        insert_node(1,226);
        insert_node(2,875);
        insert_node(3,604);
        insert_node(4,550);
        insert_node(5,498);
        insert_node(6,875);
        insert_node(7,847);
        insert_node(8,633);
        insert_node(9,793);
        insert_node(10,872);
        insert_node(11,313);
        insert_node(12,440);
        insert_node(13,331);
        insert_node(14,582);
        insert_node(15,188);
        insert_node(16,476);
        insert_node(17,722);
        insert_node(18,402);
        insert_node(19,890);
        insert_node(20,713);
        insert_node(21,421);
        insert_node(22,930);
        insert_node(23,579);
        insert_node(24,459);
        insert_node(25,278);
        insert_node(26,818);
        insert_node(27,320);
        insert_node(28,549);
        insert_node(29,240);
        insert_node(30,528);
        insert_node(31,367);
        insert_node(32,835);
        insert_node(33,20);
        insert_node(34,170);
        insert_node(35,903);
        insert_node(36,242);
        insert_node(37,943);
        insert_node(38,802);
        insert_node(39,145);
        insert_node(40,291);
        insert_node(41,224);
        insert_node(42,400);
        insert_node(43,43);
        insert_node(44,355);
        insert_node(45,83);
        insert_node(46,26);
        insert_node(47,816);
        insert_node(48,477);
        insert_node(49,425);
        insert_node(50,543);
        insert_node(51,211);
        insert_node(52,799);
        insert_node(53,185);
        insert_node(54,5);
        insert_node(55,184);
        insert_node(56,150);
        insert_node(57,572);
        insert_node(58,626);
        insert_node(59,109);
        insert_node(60,807);
        delete_nodeNew(25);
//        delete_node(63);
        print_ll();
        insert_node(3,3);
    }
}
