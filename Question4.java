package in.ineuron.main;
class Node {
    int data;
    Node next, random;
	public Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class Question4{
    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Insert new nodes next to the original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Set the random pointers of the new nodes
        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        // Step 3: Separate the original list and the new list
        current = head;
        Node newHead = current.next;
        while (current != null) {
            Node temp = current.next;
            current.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            current = current.next;
        }

        return newHead;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Data: " + current.data);
            if (current.random != null)
                System.out.print(", Random: " + current.random.data);
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Create the linked list
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node2;
        node2.random = node4;

        // Copy the linked list
        Node newHead = copyRandomList(node1);

        // Print the new list
        printList(newHead);
    }
}