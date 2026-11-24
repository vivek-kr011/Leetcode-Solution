class TreeAncestor {

    int LOG;
    int[][] up;

    public TreeAncestor(int n, int[] parent) {

        // Maximum number of bits needed to represent the ancestor distance
        LOG = 32 - Integer.numberOfLeadingZeros(n);

        up = new int[n][LOG];

        // Step 1: Store the immediate parent of every node
        // up[node][0] represents the 1st ancestor
        for (int node = 0; node < n; node++) {
            up[node][0] = parent[node];
        }

        // Step 2: Build the Binary Lifting table
        // Each column stores ancestors at powers of 2 distances
        for (int j = 1; j < LOG; j++) {

            for (int node = 0; node < n; node++) {

                // Find the ancestor at the previous jump distance
                int mid = up[node][j - 1];

                if (mid == -1) {
                    // If no ancestor exists, store -1
                    up[node][j] = -1;
                } else {
                    // Find the 2^j-th ancestor using two smaller jumps
                    up[node][j] = up[mid][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        // Start checking bits from the rightmost bit
        int bit = 0;

        while (k > 0) {

            // Check if the current bit of k is set (1)
            if ((k & 1) == 1) {

                // Jump 2^bit levels up
                node = up[node][bit];

                // If the ancestor does not exist, return -1
                if (node == -1) {
                    return -1;
                }
            }

            // Move to the next bit of k
            k = k >> 1;
            bit++;
        }

        // Return the final ancestor
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */