class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        helper(answer, root);
        return answer;
    }
    public void helper(List<Integer> answer, TreeNode root){
        if(root == null){
            return;
        }
        helper(answer, root.left);
        helper(answer, root.right);
        answer.add(root.val);
        return;
    }
}

// TC - O(N)
// sc - O(H)