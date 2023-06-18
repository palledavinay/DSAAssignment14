package in.ineuron.main;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question1 {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // If there is no loop, return the list as it is
        if (slow != fast) {
            return;
        }

        // Reset the slow pointer to the head
        slow = head;

        // Move both pointers one step at a time until they meet again
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Set the next pointer of the node at the end of the loop to null
        fast.next = null;
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
        // Create a linked list: 1 -> 3 -> 4 -> 3 (loop)
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create a loop

        Node head = node1;

        // Remove the loop from the linked list
        removeLoop(head);

        // Print the updated list
        printLinkedList(head);
    }
}