/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        
        // STEP 1: Original list ke beech me copy nodes insert karo
        while (curr != null) {
            Node nextNode = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;
            curr = nextNode;
        }

        curr = head;
        // STEP 2: Random pointers ko wire up karo
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Do step aage badho (kyunki beech me copy node hai)
        }

        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        
        // STEP 3: Dono lists ko alag-alag karo
        while (curr != null) {
            Node nextNode = curr.next.next;
            
            // Copy list ko extract karo
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            
            // Original list ko wapas theek karo
            curr.next = nextNode;
            
            curr = nextNode;
        }

        return dummyHead.next;
    }
}