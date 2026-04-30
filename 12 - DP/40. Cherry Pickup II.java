class Solution {
    public int cherryPickup(int[][] g) {
         int m = g.length;
        int n = g[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i = 0; i<m ;++i){
            for(int j = 0; j<n; ++j){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 0, n-1, dp, g);
    }
    public int helper(int r, int f1, int f2, int[][][] dp, int[][] g){
        if(f1 < 0 || f2 < 0 || f1 >= g[0].length || f2 >= g[0].length) return Integer.MIN_VALUE;
        if(r == g.length-1){
            if(f1 == f2) return g[r][f1];
            return g[r][f1] + g[r][f2]; 
        }
        if(dp[r][f1][f2] != -1) return dp[r][f1][f2];
        int max = Integer.MIN_VALUE;
        for(int i = -1; i<=1; ++i){
            for(int j = -1; j<=1; ++j){
                int val;
                if(f1 == f2){
                    val = g[r][f1];
                } else {
                    val = g[r][f1] + g[r][f2];
                }
                max = Math.max(max, val + helper(r+1, f1+i, f2+j, dp, g));
            }
        }
        dp[r][f1][f2] = max;
        return dp[r][f1][f2];
    }
}

// tc = sc = O(m*n*n)
