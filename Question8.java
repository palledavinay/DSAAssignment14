package in.ineuron.main;
class ListNode8 {
    int val;
    ListNode8 next;

    ListNode8(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question8{
    public static ListNode8 removeZeroSumSublists(ListNode8 head) {
        ListNode8 dummy = new ListNode8(0);
        dummy.next = head;

        ListNode8 prev = dummy;
        ListNode8 curr = dummy.next;

        while (curr != null) {
            int sum = 0;
            while (curr != null) {
                sum += curr.val;
                if (sum == 0) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
            prev = prev.next;
            if (prev != null) {
                curr = prev.next;
            }
        }

        return dummy.next;
    }

    public static void printList(ListNode8 head) {
        ListNode8 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list
        ListNode8 node1 = new ListNode8(1);
        ListNode8 node2 = new ListNode8(2);
        ListNode8 node3 = new ListNode8(-3);
        ListNode8 node4 = new ListNode8(3);
        ListNode8 node5 = new ListNode8(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Remove zero sum sublists
        ListNode8 result = removeZeroSumSublists(node1);

        // Print the result
        printList(result);
    }
}