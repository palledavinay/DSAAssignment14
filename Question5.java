package in.ineuron.main;
class ListNode5 {
    int val;
    ListNode5 next;

    ListNode5(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question5 {
    public static ListNode5 oddEvenList(ListNode5 head) {
        if (head == null || head.next == null)
            return head;

        ListNode5 oddHead = head;
        ListNode5 evenHead = head.next;
        ListNode5 odd = oddHead;
        ListNode5 even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return oddHead;
    }

    public static void printList(ListNode5 head) {
        ListNode5 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list
        ListNode5 node1 = new ListNode5(1);
        ListNode5 node2 = new ListNode5(2);
        ListNode5 node3 = new ListNode5(3);
        ListNode5 node4 = new ListNode5(4);
        ListNode5 node5 = new ListNode5(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Rearrange the linked list
        ListNode5 rearrangedHead = oddEvenList(node1);

        // Print the rearranged list
        printList(rearrangedHead);
    }
}
