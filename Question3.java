package in.ineuron.main;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class Question3 {
    public static Node mergeLists(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.bottom = mergeLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeLists(a, b.bottom);
        }

        return result;
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;

        // Merge the current node's list with the flattened list obtained so far
        head.next = flattenLinkedList(head.next);
        head = mergeLists(head, head.next);

        return head;
    }

    public static void printFlattenedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list with sub-linked lists
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(19);
        Node node4 = new Node(28);
        Node node5 = new Node(7);
        Node node6 = new Node(20);
        Node node7 = new Node(22);
        Node node8 = new Node(35);
        Node node9 = new Node(8);
        Node node10 = new Node(50);
        Node node11 = new Node(40);
        Node node12 = new Node(30);
        Node node13 = new Node(45);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.bottom = node5;
        node2.bottom = node6;
        node3.bottom = node7;
        node4.bottom = node8;
        node5.bottom = node9;
        node6.bottom = node10;
        node7.bottom = node11;
        node9.bottom = node12;
        node11.bottom = node13;

        Node head = node1;

        // Flatten the linked list
        head = flattenLinkedList(head);

        // Print the flattened list
        printFlattenedList(head);
    }
}