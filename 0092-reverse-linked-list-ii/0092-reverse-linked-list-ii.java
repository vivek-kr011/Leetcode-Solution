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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prevNode to the node before 'left'
        ListNode prevNode = dummy;

        for(int i = 1; i < left; i++){
            prevNode = prevNode.next;
        }

        // currNode is the first node of the portion to reverse
        ListNode currNode = prevNode.next;

        // Reverse from left to right
        for(int i = 0; i < right - left; i++) {

            ListNode nextNode = currNode.next;
            currNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }

        return dummy.next;
        
    }
}