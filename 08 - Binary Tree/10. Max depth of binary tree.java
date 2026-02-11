class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(1+maxDepth(root.left), 1+maxDepth(root.right));
    }
}

// TC - O(N) where N is the number of nodes in the tree
// SC - O(H) where H is the height of the tree