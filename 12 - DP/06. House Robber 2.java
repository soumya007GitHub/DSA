class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int first = robHelper(0, nums.length-2, nums);
        int second = robHelper(1, nums.length-1, nums);
        return Math.max(first, second);
    }
    public int robHelper(int start, int end, int[] nums){
        int prev2 = 0;
        int prev1 = 0;
        for(int i = start; i<=end; ++i){
            int temp = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}

// TC - O(N)
// SC - O(1)