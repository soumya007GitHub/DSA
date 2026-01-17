class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        helper(nums, index+1, sum-nums[index], inner, answer);
        inner.remove(inner.size()-1);
        
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        helper(nums, nextIndex, sum, inner, answer);
    }
}

// TC - O(2^N*k)
// SC - O(K*L)