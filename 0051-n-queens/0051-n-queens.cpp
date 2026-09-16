class Solution {
public:

    bool isSafe(vector<string> &board, int row, int col, int n) { // O(n)
        // Horizontally check
        for(int j = 0; j < n; j++){
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // vertically check
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Left Diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Right Diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }


    void nQueens(vector<string> &board, int row, int n, vector<vector<string>> &ans) {

        if(row == n) {
            ans.push_back({board});
            return;
        }

        // all possible col check
        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j, n)) {
                board[row][j] = 'Q'; // queen place

                nQueens(board, row+1, n, ans); // recursive call

                board[row][j] = '.';  // after backtrack ( queen remove)
            }
        }
    }

    vector<vector<string>> solveNQueens(int n) {
        
        vector<string> board(n, string(n,'.')); // initialization of board
        vector<vector<string>> ans;

        nQueens(board, 0, n, ans);

        return ans;
    }
};