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

    // check 2 tree same / identiacl hai ya nahi ( exact same ditto)
    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        
        if(root == null && subRoot == null) {
            return true; // means identical
        } else if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        // left_sutree mein non-identical
        if(!isIdentical(root.left, subRoot.left)) {
            return false;
        }

        // right_sutree mein non-identical
        if(!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null) {
            return false;
        }

        // har bar root par jayenge aur  root.data se subRoot.data ke sath compare kar lenge
        if(root.val == subRoot.val) {

            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}