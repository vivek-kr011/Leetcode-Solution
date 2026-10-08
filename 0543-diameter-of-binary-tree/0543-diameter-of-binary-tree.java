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

    int ans = 0;

    public int height(TreeNode root) {  

        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        ans = Math.max(ans, leftHeight + rightHeight); // by adding this code is optimized linear TC

        // leftHeight + rightHeight => currDiam od root node, which we calculate for each single node in the BT when we are calculating the height

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        // if(root == null) {  // O(n*n)
        //     return 0;
        // }

        // int leftDiam = diameterOfBinaryTree(root.left);
        // int rightDiam = diameterOfBinaryTree(root.right);

        // // Diameter pass throught the root node
        // int currDiam = height(root.left) + height(root.right); 

        // return Math.max(currDiam, Math.max(leftDiam, rightDiam)); 

        height(root); // O(n)
        return ans;
    }
}