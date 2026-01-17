class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
         return helper(nums, 0, k);
    }
    public boolean helper(int[] nums, int index, int sum){
    if(sum == 0){
        return true;
    }
    if(index == nums.length || sum < 0){
        return false;
    }
    return helper(nums, index+1, sum-nums[index]) || helper(nums, index+1, sum);
    }
}

// TC - O(2^N)
// SC - O(N)