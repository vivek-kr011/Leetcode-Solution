class Solution {

    private boolean isSafe(char[][] board, int row, int col, int digit) {
        // horizontal check
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == digit) {
                return false;
            }
        }

        // vertically check ( col check )
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == digit) {
                return false;
            }
        }

        // Grid Check (3x3), sr = starting row, sc = starting col O(9)
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        

        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++) {
                if(board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean helper(char[][] board, int row, int col) {

        // base case
        if(row == 9) {
            return true;
        }

        // // Calculate next cell coordinates
        int nextRow = row, nextCol = col + 1;
        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell is already filled
        if(board[row][col] != '.') {
            return helper(board, nextRow, nextCol);
        }

        // PLACE THE DIGIT
        for(char digit = '1'; digit <= '9'; digit++){

            if(isSafe(board, row, col, digit)) {  // => if this function return true

                board[row][col] = digit;  // digit place

                if (helper(board, nextRow, nextCol) ) {// => if this function return true
                    return true;
                }

                board[row][col] = '.'; // => replace the digit
            }
        }

        return false; // if no ans found
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}