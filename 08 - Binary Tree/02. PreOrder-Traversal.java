class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
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
// sc - O(H)