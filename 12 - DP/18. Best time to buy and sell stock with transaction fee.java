class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<prices.length; ++i){
            for(int j = 0; j<2; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, fee, prices, dp);
    }
    public int helper(int index, int buyStatus, int fee, int[] prices, int[][] dp){
        if(index == prices.length) return 0;
        if(dp[index][buyStatus] != -1) return dp[index][buyStatus];
        int ans = Integer.MIN_VALUE;
        // Didn't purchased any other stock previously
        if(buyStatus == 0){
            // purchase current stock
            int buy = -prices[index] + helper(index+1, 1, fee, prices, dp);
            // skip current stock
            int notBuy = helper(index+1, 0, fee, prices, dp);
            ans = Math.max(buy, notBuy);
        }
        // purchased any other stock previously
        else{
            // sell stock
            int sell = prices[index] - fee + helper(index+1, 0, fee, prices, dp);
            // dont sell stock
            int notSell = helper(index+1, 1, fee, prices, dp);
            ans = Math.max(sell, notSell);
        }
        dp[index][buyStatus] = ans;
        return dp[index][buyStatus];
    }
}

// TC - O(N*2)
// SC - O(N*2)