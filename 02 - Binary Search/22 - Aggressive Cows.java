class Solution {
    public int findPages(int[] nums, int m) {
        if (m > nums.length) return -1;
        int low = nums[0];
        int high = nums[0];
        for(int i = 1; i<nums.length; ++i){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int count = 1;
            int tempSum = 0;
            for(int i = 0; i<nums.length; ++i){
                if(tempSum + nums[i] <= mid){
                    tempSum += nums[i];
                }else{
                    ++count;
                    tempSum = nums[i];
                }
            }
            if(count <= m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

// TC - O(nLog(sumOfElements))
// SC - O(1)