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

 /* follow Reverse Pre-Order ( left, right, root) and track lastVisited Node using nextRight. TC O(n). {before doing backtrack nextRight become root}*/
class Solution {

    TreeNode nextRight = null; // last visitied node
    public void flatten(TreeNode root) {

        if(root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}