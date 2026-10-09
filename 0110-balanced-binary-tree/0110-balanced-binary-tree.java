/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/* key idea: Use post-order DFS to compute height and check balance simultaneously. TC=O(n) */
class Solution {
    public boolean isBalanced(TreeNode root) {

        return calculateHeight(root) != -1;
        
    }

    private int calculateHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = calculateHeight(root.left);
        // if LH & RH is unbalanced means -1 then do not check further, return -1
        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = calculateHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        /* Current Node check, gap of left and right is greater than 1...  */
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}