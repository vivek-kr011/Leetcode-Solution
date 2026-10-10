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

    // Ise global rakha hai taaki left aur right dono subtrees ko sahi index mile.
    private int preIdx = 0; 

    // Yeh simple function inorder array me kisi value ki sahi position (index) dhundhta hai
    private int search(int[] inorder, int left, int right, int val) {
        for(int i = left; i <= right; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {

        if(left > right) {
            return null;
        }

        /* Root construct */
        // Uses the global preIdx
        TreeNode root = new TreeNode(preorder[preIdx]);

        // inorder me root ke left wale elements left tree me jayenge, aur right wale right tree me
        int inIdx = search(inorder, left, right, preorder[preIdx]);
        preIdx++;
        
        root.left = helper(preorder, inorder, left, inIdx-1);
        root.right = helper(preorder, inorder, inIdx+1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preIdx = 0; // // Reset for every new test case
        return helper(preorder, inorder, 0, inorder.length -1);
    }
}