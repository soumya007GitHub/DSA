class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return helper(nums, 0, k);
    }
    public int helper(int[] nums, int index, int sum){
        if(sum == 0){
            return 1;
        }
        if(index == nums.length || sum < 0){
            return 0;
        }
        int take = helper(nums, index+1, sum-nums[index]);
        int notTake = helper(nums, index+1, sum);
        return take+notTake;
    }
}

// TC - O(2^n)
// SC - O(n)