class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<=coins.length; ++i){
            for(int j = 1; j<=amount; ++j){
                // coin can be taken
                if(coins[i-1] <= j){
                    // take
                    int take = dp[i][j-coins[i-1]];
                    // not take
                    int notTake = dp[i-1][j];
                    dp[i][j] = take+notTake;
                }
                // coin cannot be taken
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
// TC - O(N*M)
// SC - O(N*M)