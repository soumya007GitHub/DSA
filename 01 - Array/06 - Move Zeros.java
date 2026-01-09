class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }
        if(j >= nums.length){
        while(i < nums.length){
            nums[i] = 0;
            ++i;
        }
        }
    }
}


// TC - O(N) SC - O(1)