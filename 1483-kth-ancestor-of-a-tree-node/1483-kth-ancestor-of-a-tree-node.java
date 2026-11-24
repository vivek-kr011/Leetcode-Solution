class TreeAncestor {

    int LOG;
    int[][] up;

    public TreeAncestor(int n, int[] parent) {

        // We need 16 columns because n <= 50000
        // These columns represent jumps of 1, 2, 4, 8, 16... levels
        LOG = 16;

        up = new int[n][LOG];

        // Step 1: Store the immediate parent of every node
        // up[node][0] means the 1st ancestor of the node
        for (int node = 0; node < n; node++) {
            up[node][0] = parent[node];
        }

        // Step 2: Build the Binary Lifting table
        // Each next column stores ancestors at double the previous distance
        for (int j = 1; j < LOG; j++) {

            for (int node = 0; node < n; node++) {

                // Find the ancestor after the previous jump
                // mid mein current node ka previous jump result store hota hai.
                int mid = up[node][j - 1];

                if (mid == -1) {
                    // If the ancestor does not exist, store -1
                    up[node][j] = -1;
                } else {
                    // Reach the 2^j-th ancestor using two smaller jumps
                    up[node][j] = up[mid][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        // Start checking the binary bits of k from right to left
        int bit = 0;

        while (k > 0) {

            // Check whether the current rightmost bit is 1
            if ((k & 1) == 1) {

                // If bit is 1, jump 2^bit levels up
                node = up[node][bit];

                // If no ancestor exists, return -1
                if (node == -1) {
                    return -1;
                }
            }

            // Remove the current rightmost bit
            // Move to the next bit of k
            k = k >> 1;

            // Move to the next ancestor jump distance
            bit++;
        }

        // Return the final Kth ancestor
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */