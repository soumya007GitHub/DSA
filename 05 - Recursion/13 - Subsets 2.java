class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), answer);
        return answer;
    }
    public void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> answer){
        answer.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            helper(i + 1, nums, temp, answer);
            temp.remove(temp.size() - 1);
        }
    }
}

// TC - O(nlogn)+O(2^N) = O(2^N)
// sc - o(n)