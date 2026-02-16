class Solution {
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        height(root);
        return max;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, height(root.left));
        int right = Math.max(0, height(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left+root.val,right+root.val);
    }
}

// TC - O(N) - N is the number of nodes in the tree
// SC - O(H) - H is the height of the tree