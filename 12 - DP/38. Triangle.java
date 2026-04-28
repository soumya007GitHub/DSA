class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -100);
        }
        return helper(0, 0, triangle, dp);
    }
    public int helper(int row, int col, List<List<Integer>> triangle, int[][] dp){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != -100) return dp[row][col];

        int curr = helper(row+1, col, triangle, dp);
        int next = helper(row+1, col+1, triangle, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(prev, next);
        return dp[row][col];
    }
}

// TC - o(n*n)
// SC - o(n*n)
