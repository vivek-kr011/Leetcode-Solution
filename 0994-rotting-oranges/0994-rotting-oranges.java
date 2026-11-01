class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        /* We have to insert the indexes in the pairs */
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0; // count fresh oranges

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2){  // ROTTEN orange add in queue 
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0; // count the minutes

        /* Create Direction for the cell */
        int[][] directions = { {0,-1}, {-1,0}, {0,1}, {1,0} };

        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions) {
                    int nr = r + dir[0];    // new row ( nr )
                    int nc = c + dir[1];    // new Col ( nc )

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;

    }
}