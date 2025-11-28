class Solution {
    public int missingNumber(int[] nums) {
        int total = nums.length*(nums.length+1)/2;
        int sum = 0;
        for(int i = 0; i<nums.length; ++i){
            sum += nums[i];
        }
        return total-sum;
    }
}

// TC - O(N) SC - O(1)