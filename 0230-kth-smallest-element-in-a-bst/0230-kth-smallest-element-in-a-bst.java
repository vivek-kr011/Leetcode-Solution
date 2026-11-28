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

    // BST ke saare elements ko sorted order mein store karne ke liye ArrayList use kiye hai
    ArrayList<Integer> arr = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        // Inorder traversal se BST ke saare elements ArrayList mein store honge
        inorder(root);

        // ArrayList mein kth smallest element (k-1) index par milega
        return arr.get(k-1);
    }

    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);

        // Current node ki value ArrayList mein store karo
        arr.add(root.val);

        inorder(root.right);
        
    }
}