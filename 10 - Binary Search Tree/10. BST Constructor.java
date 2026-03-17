class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
            TreeNode answer = stack.pop();
            if(answer.right != null){
                TreeNode temp = answer.right;
                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return answer.val;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty()){
            return true;
        }
        return false;
    }
}

// TC - O(1)
// SC - O(H)