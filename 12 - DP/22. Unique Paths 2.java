class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i<obstacleGrid.length; ++i){
            for(int j = 0; j<obstacleGrid[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, obstacleGrid.length, obstacleGrid[0].length, dp, obstacleGrid);
    }
    public int helper(int c_row, int c_col, int row, int col, int[][] dp, int[][] obstacleGrid){
        if(c_row < row && c_col < col && obstacleGrid[c_row][c_col] == 1) return 0;
        if(c_row == row-1 && c_col == col-1) return 1;
        if(c_row >= row || c_col >= col) return 0;
        if(dp[c_row][c_col] != -1) return dp[c_row][c_col];
        else{

            int right = helper(c_row, c_col+1, row, col, dp, obstacleGrid);
            int bottom =  helper(c_row+1, c_col, row, col, dp, obstacleGrid);
            dp[c_row][c_col] = right+bottom;
        }
        return dp[c_row][c_col];
    }
}
// TC - O(M*N)
// SC - O(M*N)