class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; ++i){
                set.add(nums[i]);
        }
        int[] nums2 = new int[set.size()];
        int now = 0;
        for(int val:set){
            nums2[now] = val;
            ++now;
        }
        Arrays.sort(nums2);
        int[][] dp = new int[nums.length+1][nums2.length+1];
        for(int i = 1; i<=nums.length; ++i){
            for(int j = 1; j<=nums2.length; ++j){
                if(nums[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int left = dp[i-1][j];
                    int top = dp[i][j-1];
                    dp[i][j] = Math.max(left, top);
                }
            }
        }
        return dp[nums.length][nums2.length];
    }
}
// tc - o(m*n)
// sc - o(m*n)