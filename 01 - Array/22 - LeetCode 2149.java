class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;
        int[] array = new int[nums.length];
        for(int i = 0; i<nums.length; ++i){
            if(nums[i] >= 0){
                array[posIndex] = nums[i];
                posIndex += 2;
            }else if(nums[i] < 0){
                array[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return array;
    }
}

// Time Complexity is - O(N) Space Complexity is O(N)