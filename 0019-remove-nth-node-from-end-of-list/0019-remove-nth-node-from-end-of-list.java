/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node is placed before head
        ListNode dummy = new ListNode(0, head);

        // Slow and fast start from dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Create a gap of n nodes
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete the Nth node from the end
        slow.next = slow.next.next;

        // Return the actual head
        return dummy.next;
    }
}