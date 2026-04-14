class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length+1][capacity+1];
        for(int i = 1; i<=val.length; ++i){
            for(int j = 1; j<=capacity; ++j){
                if(wt[i-1] <= j){
                int take = val[i-1] + dp[i][j-wt[i-1]];
                int notTake = dp[i-1][j];
                dp[i][j] = Math.max(take, notTake);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][capacity];
    }
}
// TC - O(m*n)
// SC - O(m*n)