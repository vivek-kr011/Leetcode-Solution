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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Stores the previous node
        ListNode curr = head; // Stores the current node
        ListNode next = null; // Stores the next node temporary pointer

        while (curr != null) {
            next = curr.next; // Save the next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev one step forward
            curr = next;      // Move curr one step forward
        }
        
        return prev; // New head of the reversed list
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate the total size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If we need to remove the first node (head)
        if (n == size) {
            return head.next; 
        }

        // Traverse to the node right before the targeted node
        int i = 1;
        int idxToFind = size - n;
        ListNode prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }

        // Skip the targeted node
        prev.next = prev.next.next;
        
        return head;
    }

    
}
