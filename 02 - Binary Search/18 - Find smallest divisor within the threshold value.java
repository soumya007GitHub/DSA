class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        for(int i = 1; i<nums.length; ++i){
            high = Math.max(high, nums[i]);
        }
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int sum = 0;
            for(int i = 0; i<nums.length; ++i){
                sum += Math.ceil((double)nums[i]/mid);
            }
            if(sum <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

// TC - O(nLog(Max(nums)))
// SC - O(1)