class Solution {
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
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
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
}

//  TC - O(N) - N is the number of nodes in the tree
// SC - O(H) - H is the height of the tree