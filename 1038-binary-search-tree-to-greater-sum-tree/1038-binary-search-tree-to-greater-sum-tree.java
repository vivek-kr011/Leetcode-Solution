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

 /* We follow the Reverse In-Order traversal (right -> root -> left) */
class Solution {

    private int curr_sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        convertToGst(root);
        return root;
    }

    private void convertToGst(TreeNode root) {
        if(root == null) {
            return;
        }

        convertToGst(root.right);

        curr_sum += root.val;
        root.val = curr_sum;

        convertToGst(root.left);

    }
}