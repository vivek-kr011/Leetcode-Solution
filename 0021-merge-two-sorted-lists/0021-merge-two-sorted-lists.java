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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        
        // Base Case
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        // case 1
        if(head1.val <= head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);

            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);

            return head2;
        }

    }
}