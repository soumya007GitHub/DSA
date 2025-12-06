import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int i = 1; i<nums.length; ++i){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

// Works for both positive/negative elements in an array to find max sum of subArray
// TC - O(N) SC - O(1)


// To find the subarray with maximum sum