class Solution {
    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        dp[0] = 0;
        for(int i = 1; i<heights.length; ++i){
            int step = Integer.MAX_VALUE;
            for(int j = 1; j<=k; ++j){
                if(i-j >= 0){
                step = Math.min(step, dp[i-j]+Math.abs(heights[i-j]-heights[i]));
                }
            }
            dp[i] = step;
        }
        return dp[heights.length-1];
    }
}

// TC - O(N*K)
// SC - O(N)