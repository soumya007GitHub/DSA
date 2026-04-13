class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        return helper(W, val, wt, 0, dp);
    }

    public int helper(int totalWeight, int val[], int wt[], int index, int[][] dp){
        if(totalWeight == 0 || index >= val.length) return 0;

        if(wt[index] <= totalWeight){
            int take = val[index] + helper(totalWeight - wt[index], val, wt, index + 1, dp);
            int notTake = helper(totalWeight, val, wt, index + 1, dp);
            return Math.max(take, notTake);
        }

        return helper(totalWeight, val, wt, index + 1, dp);
    }
}
// TC = O(2^N), SC = O(N) - Recursion

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length+1][W+1];

        return helper(W, val, wt, 0, dp);
    }

    public int helper(int totalWeight, int val[], int wt[], int index, int[][] dp){
        if(totalWeight == 0 || index >= val.length) return 0;

        if(dp[index][totalWeight] != 0) return dp[index][totalWeight];

        if(wt[index] <= totalWeight){
            int take = val[index] + helper(totalWeight - wt[index], val, wt, index + 1, dp);
            int notTake = helper(totalWeight, val, wt, index + 1, dp);
            return dp[index][totalWeight] = Math.max(take, notTake);
        }

        return dp[index][totalWeight] = helper(totalWeight, val, wt, index + 1, dp);
    }
}
// TC - O(W * VAL.LENGTH), SC - O(W * VAL.LENGTH) + O(N) - Memoization


class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length+1][W+1];
        for(int i = 0; i<=val.length; ++i){
            dp[i][0] = 0;
        }
        for(int i = 0; i<=W; ++i){
            dp[0][i] = 0;
        }
        for(int i = 1; i<=val.length; ++i){
            for(int j = 1; j<=W; ++j){
                if(wt[i-1] <= j){
                    int take = val[i-1]+dp[i-1][j-wt[i-1]];
                    int notTake = dp[i-1][j];
                    dp[i][j] = Math.max(take, notTake);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
}
// TC = SC = O(number of items*total weight of bag) - Tabulation
