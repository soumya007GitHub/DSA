class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        helper(candidates, 0, target, inner, answer);
        return answer;
    }
    public void helper(int[] nums, int index, int sum, List<Integer> inner, List<List<Integer>> answer){
        if(sum == 0){
            answer.add(new ArrayList<>(inner));
            return;
        }
        if (index == nums.length || sum < 0) {
            return;
        }
        inner.add(nums[index]);
        helper(nums, index, sum-nums[index], inner, answer);
        inner.remove(inner.size()-1);
        helper(nums, index+1, sum, inner, answer);
    }
}

// TC - O(2^N*K)
// SC - O(K*L) - L - Length of each inner arraylist, K - total number of arraylist