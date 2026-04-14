class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num:nums) total += num;
        if(total % 2 != 0) return false;
        boolean[][]  dp = new boolean[nums.length+1][(total/2)+1];
        for(int i = 0; i<=nums.length; ++i){
            dp[i][0] = true;
        }
        for(int i = 1; i<=nums.length; ++i){
            for(int j = 1; j<=total/2; ++j){
                if(nums[i-1] <= j && dp[i-1][j-nums[i-1]]) dp[i][j] = true;
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][(total/2)];
    }
}
// TC - O(m*n)
// SC - O(M*N)