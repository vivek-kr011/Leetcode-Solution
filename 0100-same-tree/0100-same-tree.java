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
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true; // means identical
        } else if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        // left_sutree mein non-identical
        if(!isSameTree(root.left, subRoot.left)) {
            return false;
        }

        // right_sutree mein non-identical
        if(!isSameTree(root.right, subRoot.right)) {
            return false;
        }

        return true;

    }
}