class Solution {
    public int ninjaTraining(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][3];
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<3; ++j){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i<3; ++i){
            max = Math.max(max, helper(0, i, matrix, dp));
        }
        return max;
    }
    public int helper(int r, int c, int[][] matrix, int[][] dp){
        if(r >= matrix.length || c >= 3) return 0;
        if(dp[r][c] != -1) return dp[r][c];
        int temp = matrix[r][c];
        int temp2 = Integer.MIN_VALUE;
        for(int i = 0; i<3; ++i){
            if(c != i){
                temp2 = Math.max(temp2, helper(r+1, i, matrix, dp));
            }
        }
        temp += temp2;
        dp[r][c] = temp;
        return dp[r][c];
    }
}

//tc - o(m)
// sc- o(m)
