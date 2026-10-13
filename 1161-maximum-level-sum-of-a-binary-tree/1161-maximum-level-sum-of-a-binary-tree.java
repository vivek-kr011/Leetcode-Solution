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
    public int maxLevelSum(TreeNode root) {

        // BFS + Level Order Traversal 
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); // we can use offer aur add 

        int max_Sum = Integer.MIN_VALUE; // current maximum level sum

        int level = 1;  // Current level number ( root )

        int ans = 1;  // // Maximum sum wale level ka answer

        while (!q.isEmpty()) {

            // Current level par kitne nodes hain
            int size = q.size();

            int curr_Sum = 0;  // sum = 0 , in each level

            /* Run the for loop, to precess the curr_Levle nodes */
            for (int i = 0; i < size; i++) {

                TreeNode node = q.remove();

                curr_Sum += node.val;  // curr Node ki value ko level sum me add kiya
                
                // check the left child
                if (node.left != null) {
                    q.add(node.left);
                }

                // check the right child
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // current level maximum hai ya nahi
            if (curr_Sum > max_Sum) {
                max_Sum = curr_Sum;
                ans = level;
            }

            // increase the level
            level++;
        }

        return ans;  // maximum level ke sum return karega
    }
}