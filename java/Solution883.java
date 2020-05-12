class Solution883 {

    /*
        T: O(N^2)
        S: O(1)
    */
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            int bestRow = 0;
            int bestCol = 0;

            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0)
                    ans++;

                if (grid[i][j] > bestRow)
                    bestRow = grid[i][j];
                if (grid[j][i] > bestCol)
                    bestCol = grid[j][i];
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }
}