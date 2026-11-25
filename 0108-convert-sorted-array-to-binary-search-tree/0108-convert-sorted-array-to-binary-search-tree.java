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

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    public TreeNode createBST(int[] arr, int st, int end) {

        /* Base case */
        if (st > end) {
            return null;
        }

        /* Find Mid, and Mid becomes a root node */
        int mid = (st + end) / 2;

        /* Create New Node */
        TreeNode root = new TreeNode(arr[mid]);

        /* Recursively call for Left Subtree & Right Subtree */
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }
}