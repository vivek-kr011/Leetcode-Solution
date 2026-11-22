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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); // Store result

        if (root == null) {
            return result;
        }

        int level;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        level = 0;

        while (!q.isEmpty()) {
            // Calculate current level size
            int levelSize = q.size();

            // Add current level nodes in the inner list
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.remove();
                currentLevel.add(currNode.val);

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            // If level is ODD
            if (level % 2 != 0) {
                // Reverse currentLevel
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);

            level += 1;
        }

        return result;
    }

}