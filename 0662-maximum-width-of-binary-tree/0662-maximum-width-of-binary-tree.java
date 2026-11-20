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

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        long maxWidth = 0;

        while (!q.isEmpty()) {
            // List<TreeNode> currentLevel = new ArrayList<>(); // use in bruteforce approach

            int levelSize = q.size(); 

            // Index of the first node at the current level
            long firstIndex = q.peek().index;
            
            // Will store the index of the last node at the current level
            long lastIndex = 0; 

            // Process only the nodes belonging to the current level
            for (int i = 0; i < levelSize; i++) {
                Pair info = q.remove(); // info have 2 value - 1. Node and 2. index

                TreeNode node = info.node;
                long index = info.index;

                // Update lastIndex as we process nodes from left to right
                lastIndex = index;

                if(node.left != null) {
                    q.add(new Pair(node.left, 2*index));
                }
                if(node.right != null) {
                    q.add(new Pair(node.right, 2*index + 1));
                }
            }

            long currentWidth = lastIndex - firstIndex + 1;

            maxWidth = Math.max(maxWidth, currentWidth);

        }

        return (int) maxWidth;

     
    }
}