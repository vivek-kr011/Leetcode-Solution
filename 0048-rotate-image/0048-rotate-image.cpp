class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {

        int n = matrix.size();
        // vector<vector<int>> ans(n, vector<int>(n));

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         ans[j][n-1-i] = matrix[i][j];
        //     }
        // }

        // matrix = ans;

        /* OPTIMIAL SOL. STEP 1  =  TRANSPOSE THE MATRIX */
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                swap(matrix[i][j], matrix[j][i]);

            }
        }

        /* STEP 2  =  REVERSE EVERY ROW */
        for(int i = 0; i < n; i++) {
            // matrix[i]
            reverse(matrix[i].begin(), matrix[i].end());
        }
    }
};