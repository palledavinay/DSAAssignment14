package in.ineuron.main;
import java.util.*;

class ListNode7 {
    int val;
    ListNode7 next;

    ListNode7(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question7 {
    public static int[] nextLargerNodes(ListNode7 head) {
        List<Integer> nodeValues = new ArrayList<>();
        ListNode7 current = head;

        // Store the values of each node in an array
        while (current != null) {
            nodeValues.add(current.val);
            current = current.next;
        }

        int[] result = new int[nodeValues.size()];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the node values in reverse order
        for (int i = nodeValues.size() - 1; i >= 0; i--) {
            int currentValue = nodeValues.get(i);

            // Pop indices from the stack while the value is less than the value at the top index
            while (!stack.isEmpty() && currentValue >= nodeValues.get(stack.peek())) {
                stack.pop();
            }

            // Update the result with the next greater value if available
            if (!stack.isEmpty()) {
                result[i] = nodeValues.get(stack.peek());
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create the linked list
        ListNode7 node1 = new ListNode7(2);
        ListNode7 node2 = new ListNode7(1);
        ListNode7 node3 = new ListNode7(5);

        node1.next = node2;
        node2.next = node3;

        // Find the next greater node for each node in the linked list
        int[] result = nextLargerNodes(node1);

        // Print the result
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}