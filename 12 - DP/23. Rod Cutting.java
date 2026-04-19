class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= n; len++) {
                if (i <= len) {
                    dp[i][len] = Math.max(dp[i-1][len], price[i - 1] + dp[i][len - i]);
                }else{
                    dp[i][len] = dp[i - 1][len];
                }
            }
        }
        return dp[n][n];
    }
}
// TC = O(n*n)
// SC = O(n*n)