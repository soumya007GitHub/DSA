class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        answer.add(current);
        for(int i = 0; i<nums.length; ++i){
        helper(current, answer, nums, i, nums.length);
        }
        return answer;
    }
    public void helper(List<Integer> current, List<List<Integer>> answer, int[] nums, int index, int max){
        if(index == max){
            return;
        }
        List<Integer> newTemp = new ArrayList<>(current);
        newTemp.add(nums[index]);
        answer.add(newTemp);
        for(int i = index+1; i<nums.length; ++i){
         helper(newTemp, answer, nums, i, max);
        }
    }
}

// TC - O(N*2^N)
// SC - O(N*2^N)