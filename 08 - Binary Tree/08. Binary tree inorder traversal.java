class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
        helper(root.left, answer);
        answer.add(root.val);
        helper(root.right, answer);
    }
}
// TC - O(N)
// SC - O(H)