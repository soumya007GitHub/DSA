class Solution {
    public boolean isBalanced(TreeNode root) {
        if(checker(root) == -1){
            return false;
        }
        return true;
    }
    public int checker(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = checker(root.left);
            if(left == -1){
                return -1;
            }
        }
        if(root.right != null){
            right = checker(root.right);
            if(right == -1){
                return -1;
            }
        }
        if(left - right > 1 || right - left > 1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}
// TC - O(N) - N is the number of nodes in the tree
// SC - O(H) - H is the height of the tree