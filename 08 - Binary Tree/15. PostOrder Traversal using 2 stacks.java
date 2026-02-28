class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode current = stack1.pop();
            stack2.push(current);
            if(current.left != null) stack1.push(current.left);
            if(current.right != null) stack1.push(current.right);
        }
        List<Integer> answer = new ArrayList<>();
        while(!stack2.isEmpty()){
            answer.add(stack2.pop().val);
        }
        return answer;
    }
}

// TC - O(N) - for popping and pushing each node
// SC - O(2N) - for using 2 stacks