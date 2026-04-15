class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k];
        for(int i = 0; i<prices.length; ++i){
            for(int j = 0; j<2; ++j){
                for(int l = 0; l<k; ++l){
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(0, 0, 0, k, prices, dp);
    }
    public int helper(int day, int buyStatus, int currentTransactions, int totalTransactions, int[] prices, int[][][] dp){
        if(day == prices.length || currentTransactions == totalTransactions){
            return 0;
        }
        if(dp[day][buyStatus][currentTransactions] != -1) return dp[day][buyStatus][currentTransactions];
        int ans = Integer.MIN_VALUE;
        if(buyStatus == 0){
            int buy = -prices[day] + helper(day+1, 1, currentTransactions, totalTransactions, prices, dp);
            int notBuy = helper(day+1, 0, currentTransactions, totalTransactions, prices, dp);
            ans = Math.max(buy, notBuy);
        }else{
            int sell = prices[day] + helper(day+1, 0, currentTransactions+1, totalTransactions, prices, dp);
            int notSell = helper(day+1, 1, currentTransactions, totalTransactions, prices, dp);
            ans = Math.max(sell, notSell);
        }
        dp[day][buyStatus][currentTransactions] = ans;
        return dp[day][buyStatus][currentTransactions];
    }
}

// TC - O(N*2*K)
// SC - O(N*2*K)