class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        helper(0, 0, nums, answer);
        return answer;
    }
    public void helper(int index, int sum, int[] nums, List<Integer> answer){
        if(index == nums.length){
            answer.add(sum);
            return;
        }
        // Pick current element
        helper(index+1, sum+nums[index], nums, answer);

        // Not Pick current element
        helper(index+1, sum, nums, answer);
        return;
    }
}

// TC - O(2^N)
// SC - O(N)