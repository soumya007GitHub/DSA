class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int index = 0;
        for(int i=1; i<nums.length; ++i){
            if(nums[i] != nums[i-1]){
                ++index;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}

// TC - O(N) SC - O(1)