class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int buyDay = prices[0];
        for(int i = 1; i<prices.length; ++i){
            buyDay = Math.min(buyDay, prices[i]);
            answer = Math.max(answer, prices[i]-buyDay);
        }
        return answer;
    }
}
// TC - O(N)
//SC - O(1)