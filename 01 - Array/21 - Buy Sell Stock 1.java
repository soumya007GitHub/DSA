class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; ++i){
            buyDay = Math.min(buyDay, prices[i]);
            int currentProfit = prices[i] - buyDay;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}

// TC - O(N) SC - O(1)