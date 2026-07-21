class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix[0].length;
        int m = matrix.length;

        int r = 0, c = n-1; // r = row, c = col

        while(r < m && c >= 0) {
            if(target == matrix[r][c]) {
                return true;
            } else if(target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }

        return false;
        
    }
}