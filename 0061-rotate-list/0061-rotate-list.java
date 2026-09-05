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
    public ListNode rotateRight(ListNode head, int k) {
        // If list is empty or only one node or k = 0, return head
        if (head == null || head.next == null || k == 0)
            return head;

        // Initialize length and tail
        int length = 1;
        ListNode tail = head;

        // Traverse to find tail and calculate length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular
        tail.next = head;

        // Calculate effective rotation
        k = k % length;

        // Traverse to new tail position
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}