class Solution {
    public long subArrayRanges(int[] nums) {
        long sumOfMax = maxFinder(nums);
        long sumOfMin = minFinder(nums);
        return sumOfMax - sumOfMin;
    }
    public long maxFinder(int[] nums){
        int[] NGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // NGE
        for(int i = nums.length-1; i>=0; --i){
            if(stack.isEmpty()){
                NGE[i] = nums.length;
            }
            else{
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    NGE[i] = nums.length;
                }else{
                    NGE[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        int[] PGE = new int[nums.length];
        stack = new Stack<>();
        // PGE
        for(int i = 0; i<nums.length; ++i){
            if(stack.isEmpty()){
                PGE[i] = -1;
            }
            else{
                while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    PGE[i] = -1;
                }
                else{
                    PGE[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        long sum = 0;
        for(int i = 0; i<nums.length; ++i){
            int left = i - PGE[i];
            int right = NGE[i] - i;
            sum = sum + (long)nums[i]*left*right;
        }
        return sum;
    }
    public long minFinder(int[] nums){
        int[] NSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // NSE
        for(int i = nums.length-1; i>=0; --i){
            if(stack.isEmpty()){
                NSE[i] = nums.length;
            }
            else{
                while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    NSE[i] = nums.length;
                }else{
                    NSE[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        int[] PSE = new int[nums.length];
        stack = new Stack<>();
        // PSE
        for(int i = 0; i<nums.length; ++i){
            if(stack.isEmpty()){
                PSE[i] = -1;
            }
            else{
                while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    PSE[i] = -1;
                }
                else{
                    PSE[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        long sum = 0;
        for(int i = 0; i<nums.length; ++i){
            int left = i - PSE[i];
            int right = NSE[i] - i;
            sum = sum + (long)nums[i]*left*right;
        }
        return sum;
    }
}

// TC - O(N) where N is the length of the input array
// SC - O(N) where N is the length of the input array