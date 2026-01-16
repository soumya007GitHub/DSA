class Solution {
    public List<Integer> leaders(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length-1]);
        for(int i = nums.length-2; i>=0; --i){
            if(nums[i] > stack.peek()){
                stack.push(nums[i]);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        return answer;
    }
}

// TC - O(N)
// SC - O(N)