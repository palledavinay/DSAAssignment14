package in.ineuron.main;
class ListNode6 {
    int val;
    ListNode6 next;

    ListNode6(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question6 {
    public static ListNode6 shiftLeft(ListNode6 head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = getLength(head);
        k = k % length;

        if (k == 0)
            return head;

        ListNode6 current = head;
        for (int i = 1; i < length - k; i++) {
            current = current.next;
        }

        ListNode6 newHead = current.next;
        current.next = null;

        ListNode6 tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;

        return newHead;
    }

    public static int getLength(ListNode6 head) {
        int length = 0;
        ListNode6 current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void printList(ListNode6 head) {
        ListNode6 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list
        ListNode6 node1 = new ListNode6(2);
        ListNode6 node2 = new ListNode6(4);
        ListNode6 node3 = new ListNode6(7);
        ListNode6 node4 = new ListNode6(8);
        ListNode6 node5 = new ListNode6(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 3;

        // Shift the linked list to the left by k nodes
        ListNode6 shiftedHead = shiftLeft(node1, k);

        // Print the shifted list
        printList(shiftedHead);
    }
}