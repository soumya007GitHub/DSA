class Solution {
    public void nextPermutation(int[] nums) {
        int foundIndex = -1;
        for(int i = nums.length-2; i>=0; --i){
            if(nums[i] < nums[i+1]){
                foundIndex = i;
                break;
            }
        }
        
        int start = 0;
        int end = nums.length-1;
        if(foundIndex == -1){
        while(start<end){
            int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                ++start;
                --end;
        }
        return;
        }
        for(int i = nums.length-1; i>=0; --i){
            if(nums[i] > nums[foundIndex]){
                int temp = nums[foundIndex];
                nums[foundIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        start = foundIndex+1;
        end = nums.length-1;
        while(start<end){
            int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                ++start;
                --end;
        }
        
    }
}

// TC - O(N)
// SC - O(1)