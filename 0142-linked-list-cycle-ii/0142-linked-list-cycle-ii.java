/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /* STEP 1 - Detect Cycle */
        ListNode slow = head;
        ListNode fast = head;

        boolean cycle = false; // cycle is not exist

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true; // to track cycle is exist or not
                break;
            }
        }

        if (cycle == false) {
            return null;
        }

        /* STEP 2 - Find Meeting Point */
        slow = head;
        
        // Agar cycle pehle hi node (head) par shuru ho rahi hai, to prev ko fast par set kr denge
        ListNode prev = fast; 

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        /* STEP 3 - Remove Cycle -> last.next = null */
        prev.next = null;
        
        // cycle ka starting node return karega.
        return slow; 
    }
}
