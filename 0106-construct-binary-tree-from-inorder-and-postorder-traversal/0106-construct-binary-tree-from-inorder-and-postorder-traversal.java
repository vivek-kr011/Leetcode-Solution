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

    /* PostOrder traverse (reverse direction) = Root → Right → Left */
    int postOrderIndex;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // STEP 1: Store each inorder element and its index in HashMap
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // STEP 2: Initialize postOrderIndex to the last index of postorder
        postOrderIndex = postorder.length - 1;
         
        // STEP 3: Start building the binary tree using the complete inorder range
        return build(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {

        // STEP 1: If the subtree is empty, return null
        if(start > end) {
            return null;
        }

        // STEP 2: Get the current root value from postorder
        int rootValue = postorder[postOrderIndex];

        // STEP 3: Move to the previous index in postorder
        postOrderIndex--;   

        // STEP 4: Create a new tree node using the root value
        TreeNode root = new TreeNode(rootValue);

        // STEP 5: Find the root's index in inorder using HashMap
        int rootIndex = map.get(rootValue);

        // STEP 6: Recursively construct the right subtree and left subtree
        root.right = build(inorder, postorder, rootIndex+1, end);
        root.left = build(inorder, postorder, start, rootIndex-1);

        // STEP 8: Return the root node of the constructed subtree
        return root;
    }

}
