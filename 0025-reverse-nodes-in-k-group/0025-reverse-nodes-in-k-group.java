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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        int count = 0;

        /* step 1 - CHECK if K nodes exist */
        while(count < k) {

            if(temp == null) {
                return head;
            }

            temp = temp.next;
            count++;
        }

        /* Step 2 - Recursively call rest of the Linked List */

        ListNode prevNode = reverseKGroup(temp, k); // rest of the LL head after reverse

        /* Step 3 - Reverse the current group */
        temp = head; count = 0;  // re-initialize the value

        while(count < k) {

            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;

            count++;
        }

        return prevNode; // New head of the Linked list


    }
}