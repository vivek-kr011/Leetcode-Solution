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
class Solution {

    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        
        // Base Case
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;

        /* Step 1. Root.Left */
        if(root.left != null) {
            int leftMin = minDiffInBST(root.left);
            ans = Math.min(ans, leftMin);
        }

        /* Step 2.  Calculate curr_min */
        if(prev != null) {
            ans = Math.min(ans, root.val - prev.val);
        }

        /* Step 3. prev update to root */
        prev = root;

        /* Step 4. root.right */
        if(root.right != null) {
            int rightMin = minDiffInBST(root.right);
            ans = Math.min(ans, rightMin);
        }

        return ans;
    }   
}