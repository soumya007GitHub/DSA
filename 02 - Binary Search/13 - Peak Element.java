class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return 0;
            }else{
                return 1;
            }
        }
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[mid+1]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}

// TC - O(logN)
// SC - O(1)