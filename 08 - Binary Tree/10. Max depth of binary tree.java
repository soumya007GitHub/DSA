class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

// TC - O(N) where N is the number of nodes in the tree
// SC - O(H) where H is the height of the tree