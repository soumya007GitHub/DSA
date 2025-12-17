import java.util.*;
class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length-1]-nums[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlace(nums, mid, k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
    public boolean canWePlace(int[] nums, int dist, int cows){
        int count = 1;
        int pos = nums[0];
        for(int i = 1; i<nums.length; ++i){
            if(nums[i] - pos >= dist){
                ++count;
                pos = nums[i];
            }
            if(count >= cows){
                return true;
            }
        }
        return false;
    }
}


// TC - O(N log N) + O(N log(maxDistance))
// SC - O(1)