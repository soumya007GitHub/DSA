class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(1, 0, k, n, new ArrayList<>(), answer);
        return answer;
    }
     public void helper(int start, int count, int k, int remain, List<Integer> path, List<List<Integer>> answer) {
         if (count == k) {
            if (remain == 0) {
                answer.add(new ArrayList<>(path));
            }
            return;
        }
         if (remain < 0) return;
       for (int i = start; i <= 9; i++) {
            path.add(i);
            helper(i + 1, count + 1, k, remain - i, path, answer);
            path.remove(path.size() - 1);
        }
    }
}