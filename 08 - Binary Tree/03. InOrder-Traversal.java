class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
        answer.add(root.val);
        helper(answer, root.right);
        return;
    }
}

// TC - O(N)
// sc - O(H)