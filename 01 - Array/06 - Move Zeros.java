class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int position = 0;
        for(int i = 0; i<nums.length; ++i){
            if(nums[i] != 0){
                nums[position] = nums[i];
                ++position;
            }
            else{
                ++count;
            }
        }
        for(int i = nums.length-count; i<nums.length; ++i){
            nums[i] = 0;
        }
    }
}

// TC - O(N) SC - O(1)