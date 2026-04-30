class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, m, n, dp, grid);
    }
    public int helper(int r, int c, int tr, int tc, int[][] dp, int[][] grid){
        if(r > tr-1 || c > tc-1) return Integer.MAX_VALUE;
        if(dp[r][c] != -1) return dp[r][c];
        if(r == tr-1 && c == tc-1) return grid[r][c];
        // take right
        int right = helper(r, c+1, tr, tc, dp, grid);
        // take bottom
        int bottom = helper(r+1, c, tr, tc, dp, grid);
        dp[r][c] = grid[r][c] + Math.min(right, bottom);
        return dp[r][c];
    }
}

// TC - O(M*N)
// SC - O(M*N)
