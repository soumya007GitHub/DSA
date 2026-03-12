class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode newNode = new TreeNode(val);
            root = newNode;
            return root;
        }
        dfs(root, null, val);
        return root;
    }
    public void dfs(TreeNode root, TreeNode parent, int val){
        if(root == null){
            TreeNode newNode = new TreeNode(val);
            if(parent.val < val){
                parent.right = newNode;
            }else{
                parent.left = newNode;
            }
            return;
        }
        else if(root.val < val){
            dfs(root.right, root, val);
        }else{
            dfs(root.left, root, val);
        }
    }
}
// TC - O(N)
// SC - O(N)