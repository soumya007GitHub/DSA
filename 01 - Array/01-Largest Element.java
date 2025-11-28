class Solution {
    public int largestElement(int[] nums) {
        int max = nums[0];
        for(int i = 1; i<nums.length; ++i){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)