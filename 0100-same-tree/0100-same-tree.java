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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if(p == null && q == null) {
        //     return true; // means identical
        // } else if(p == null || q == null || p.val != q.val) {
        //     return false;
        // }

        // // left_sutree same hai ya nahi
        // if(!isSameTree(p.left, q.left)) {
        //     return false;
        // }

        // // right_sutree same hai ya nahi
        // if(!isSameTree(p.right, q.right)) {
        //     return false;
        // }

        // return true;

        /* Another Way */
        if(p == null || q == null) {
            return p == q;
        }

        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isLeftSame && isRightSame && p.val == q.val;

    }
}