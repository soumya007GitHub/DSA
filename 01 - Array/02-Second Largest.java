class Solution {
    public int secondLargestElement(int[] nums) {
    int largest = nums[0];
    int second_largest = -1;
    for(int i = 1; i<nums.length; ++i){
        if(nums[i] > largest){
            second_largest = largest;
            largest = nums[i];
        }
        else if(second_largest < nums[i] && nums[i]<largest){
            second_largest = nums[i];
        }
    }
    return second_largest;
    }
}