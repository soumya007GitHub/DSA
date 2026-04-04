class Solution {
    public int frogJump(int[] heights) {
        int[] dp = new int[heights.length];
        dp[0] = 0;
        for(int i = 1; i<heights.length; ++i){
            int stepOne = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int stepTwo = Integer.MAX_VALUE;
            if(i != 1){
                stepTwo = dp[i-2] + Math.abs(heights[i-2]-heights[i]);
            }
            dp[i] = Math.min(stepOne, stepTwo);
        }
        return dp[heights.length-1];
    }
}


// TC - O(N)
// SC - O(N)