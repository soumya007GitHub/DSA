class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for(int i = 0; i<prices.length; ++i){
            for(int j = 0; j<2; ++j){
                for(int k = 0; k<2; ++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(0, 0, 0, prices, dp);
    }
    public int helper(int day, int buyStatus, int coolDown, int[] prices, int[][][] dp){
        if(day == prices.length){
            return 0;
        }
        if(dp[day][buyStatus][coolDown] != -1) return dp[day][buyStatus][coolDown];
        int ans = Integer.MIN_VALUE;
        if(coolDown == 1){
            ans = helper(day+1, 0, 0, prices, dp);
        }
        else if(buyStatus == 0){
            int buy = -prices[day] + helper(day+1, 1, 0, prices, dp);
            int notBuy = helper(day+1, 0, 0, prices, dp);
            ans = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[day] + helper(day+1, 0, 1, prices, dp);
            int notSell = helper(day+1, 1, 0, prices, dp);
            ans = Math.max(sell, notSell);
        }
        dp[day][buyStatus][coolDown] = ans;
        return dp[day][buyStatus][coolDown];
    }
}
// TC - O(N*2*2)
// SC - O(N*2*2)