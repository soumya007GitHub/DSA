class Solution {
    public int climbStairs(int n, int[] costs) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return costs[0]+1;
        }
        if(n == 2){
            return Math.min(costs[1]+4, costs[0]+costs[1]+2);
        }
        int dp[] = new int[n+1];
        dp[1] = costs[0] + 1;
        dp[2] = costs[1] + Math.min(dp[1] + 1, 4);
        for(int i = 3; i<=n; ++i){
            dp[i] = costs[i-1] + Math.min(dp[i-1]+1, Math.min(dp[i-2]+4, dp[i-3]+9));
        }
        return dp[n];
    }
}

// TC - O(N)
// SC - O(N)