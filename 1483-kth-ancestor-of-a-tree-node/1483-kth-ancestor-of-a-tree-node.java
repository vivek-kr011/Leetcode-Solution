class TreeAncestor {

    // Total number of nodes in the tree
    int n;
    
    // Number of columns required in Binary Lifting table
    int LOG;
    
    // up[i][j] stores the 2^j-th ancestor of node i
    int[][] up;

    /* Constructor ka kaam tha ancestors ki information pehle se calculate karke rakhna. */
    public TreeAncestor(int n, int[] parent) {

        this.n = n;

        // STEP 1: Calculate the number of columns required

        LOG = 1; //humein powers of 2 ke jumps calculate karne ke liye columns chahiye.
        
        // Keep increasing LOG while 2^LOG is less than or equal to n
        // (1 << LOG) means 2^LOG
        while ((1 << LOG) <= n) {  /* << - left shift operator */
            LOG++;
        }

        // STEP 2: Create the Binary Lifting table

        // n rows = n nodes
        // LOG columns = different powers-of-2 jumps
        up = new int[n][LOG];
        
        // Initially, mark all ancestors as -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < LOG; j++) {
                up[i][j] = -1;
            }
        }

        // STEP 3: Fill the first column
        // up[i][0] stores the immediate parent (1st ancestor)
        // We get this information directly from the parent array
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // STEP 4: Calculate all remaining ancestors using Binary Lifting

        // j = 0 is already filled
        // Start from j = 1 to calculate 2nd, 4th, 8th... ancestors
        for (int j = 1; j < LOG; j++) {

            // Calculate the j-th level ancestor for every node
            for (int i = 0; i < n; i++) {
                
                // First, find the node reached after a 2^(j-1) jump
                int mid = up[i][j - 1];

                // If the intermediate node does not exist,
                // then the required ancestor also does not exist
                if (mid == -1) {
                    up[i][j] = -1;
                } else {

                    // Take another 2^(j-1) jump from the intermediate node
                    // Total jump = 2^(j-1) + 2^(j-1) = 2^j
                    up[i][j] = up[mid][j - 1];
                }
            }
        }

    }

    public int getKthAncestor(int node, int k) {
        
        // Check every bit of k from right to left
        for(int j = 0; j < LOG; j++) {

            // Check whether the j-th bit of k is set
            // If set, we need to take a jump of 2^j steps
            if(( k & (1 << j)) != 0) {

                // Move the current node to its 2^j-th ancestor
                node = up[node][j];

                // If the ancestor does not exist, return -1
                if(node == -1) {
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