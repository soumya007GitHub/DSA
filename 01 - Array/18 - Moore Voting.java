class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int element = nums[0];
        for(int i = 1; i<nums.length; ++i){
            if(count == 0){
                element = nums[i];
                count = 1;
            }else if(nums[i] == element){
                ++count;
            }else{
                --count;
            }
        }
        return element;
    }
}

// TC - O(N) SC - O(1)