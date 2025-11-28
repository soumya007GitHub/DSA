class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        // Rotate whole array
        rotationhelper(0, nums.length-1, nums);

        // rotate first k-1 places
        rotationhelper(0, k-1, nums);

        // rotate elements present after k places
        rotationhelper(k, nums.length-1, nums);
    }
    public void rotationhelper(int i, int j, int[] nums){
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
                --j;
            }
        }
}

// TC - O(N) SC - O(1)