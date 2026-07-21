class Solution {

    public boolean searchInRow(int[][] matrix, int target, int row) {

        int n = matrix[0].length;
        int st = 0, end = n - 1;

        // Apply Binary Search
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                st = mid + 1;   // Search in right part
            } else {
                end = mid - 1;  // Search in left part
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows and columns
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m - 1;

        // Binary Search on Rows
        while (startRow <= endRow) {

            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= matrix[midRow][0] &&
                target <= matrix[midRow][n - 1]) {

                // Target can exist in this row
                return searchInRow(matrix, target, midRow);

            } else if (target >= matrix[midRow][0]) {

                // Go downward
                startRow = midRow + 1;

            } else {

                // Go upward
                endRow = midRow - 1;
            }
        }

        return false;
    }
} 