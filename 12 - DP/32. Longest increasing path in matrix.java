class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                dp[i][j] = -1;
            }
        }
        int ans = 0;
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<matrix[0].length; ++j){
                ans = Math.max(ans, helper(i, j, matrix, dp));
            }
        }
        return ans;
    }
    public int helper(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        int best = 1;
        // left
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            best = Math.max(best, 1+helper(i, j-1, matrix, dp));
        }
        // right
        if(j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]){
            best = Math.max(best, 1+helper(i, j+1, matrix, dp));
        }
        // top
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            best = Math.max(best, 1+helper(i-1, j, matrix, dp));
        }
        // bottom
        if(i+1 < matrix.length && matrix[i+1][j] > matrix[i][j]){
            best = Math.max(best, 1+helper(i+1, j, matrix, dp));
        }
        dp[i][j] = best;
        return dp[i][j];
    }
}
// tc - o(m*n)
// sc - o(m*n)