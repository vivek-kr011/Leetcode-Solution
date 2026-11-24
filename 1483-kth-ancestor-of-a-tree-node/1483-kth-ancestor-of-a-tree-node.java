
class TreeAncestor {

    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {

        LOG = 32 - Integer.numberOfLeadingZeros(n);

        up = new int[n][LOG];

        // Step 1: Store immediate parent
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // Step 2: Build Binary Lifting table
        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = up[i][j - 1];

                if (mid == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[mid][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        // Step 3: Process bits of k
        for (int j = 0; j < LOG; j++) {

            if ((k & (1 << j)) != 0) {

                node = up[node][j];

                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */