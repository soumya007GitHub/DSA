class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, m, n, dp);
    }
    public int helper(int c_row, int c_col, int row, int col, int[][] dp){
        if(c_row == row-1 && c_col == col-1) return 1;
        if(c_row >= row || c_col >= col) return 0;
        if(dp[c_row][c_col] != -1) return dp[c_row][c_col];
        else{
            int right = helper(c_row, c_col+1, row, col, dp);
            int bottom = helper(c_row+1, c_col, row, col, dp);
            dp[c_row][c_col] = right+bottom;
        }
        return dp[c_row][c_col];
    }
}
// TC - O(M*N)
// SC - O(M*N)