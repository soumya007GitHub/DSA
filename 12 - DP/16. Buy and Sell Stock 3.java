class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i = 0; i<prices.length; ++i){
            for(int j = 0; j<2; ++j){
                for(int k = 0; k<3; ++k){
                dp[i][j][k] = -1;
                }
            }
        }
        return helper(0, 0, 0, prices, dp);
    }
    public int helper(int day, int buyStatus, int totalTransactions, int[] prices, int[][][] dp){
        if(day == prices.length || totalTransactions == 2){
            return 0;
        }
        if(dp[day][buyStatus][totalTransactions] != -1) return dp[day][buyStatus][totalTransactions];
        int ans = Integer.MIN_VALUE;
        if(buyStatus == 0){
            int buy = -prices[day] + helper(day+1, 1, totalTransactions, prices, dp);
            int notBuy = helper(day+1, 0, totalTransactions, prices, dp);
            ans = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[day] + helper(day+1, 0, totalTransactions+1, prices, dp);
            int notSell = helper(day+1, 1, totalTransactions, prices, dp);
            ans = Math.max(sell, notSell);
        }
        dp[day][buyStatus][totalTransactions] = ans;
        return dp[day][buyStatus][totalTransactions];
    }
}
// TC - O(N*2*3)
// SC - O(N*2*3)