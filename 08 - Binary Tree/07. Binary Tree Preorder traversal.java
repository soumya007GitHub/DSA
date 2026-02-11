class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>();
        helper(root, answer);
        return answer;
    }
    public void helper(TreeNode root, List<Integer> answer){
        if(root == null){
            return;
        }
        answer.add(root.val);
        helper(root.left, answer);
        helper(root.right, answer);
        return;
    }
}
// TC - O(N)
// SC - O(H)