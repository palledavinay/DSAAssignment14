package in.ineuron.main;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question2 {
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static Node addOneToLinkedList(Node head) {
        head = reverseLinkedList(head);

        Node current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;
            if (carry == 0) {
                break;
            }
            current = current.next;
        }

        if (carry == 1) {
            Node newHead = new Node(1);
            newHead.next = head;
            head = newHead;
        }

        return reverseLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list representing the number 4 -> 5 -> 6
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);

        node1.next = node2;
        node2.next = node3;

        Node head = node1;

        // Add 1 to the linked list
        head = addOneToLinkedList(head);

        // Print the updated list
        printLinkedList(head);
    }
}