/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return null;
        } 

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA != null && rightLCA != null) {  // both values valid hogi to root ko return kar denge
            return root;
        } else if(leftLCA != null) {  // means right_LCA null hogi
            return leftLCA;
        } else {
            return rightLCA;
        }

    }
}