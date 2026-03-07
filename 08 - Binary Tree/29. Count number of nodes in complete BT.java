class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh){
            return (int)Math.pow(2, lh)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int leftHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = leftHeight(root.left);
        return lh+1;
    }
    public int rightHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int rh = rightHeight(root.right);
        return rh+1;
    }
}

// TC - O(LogN)
// SC - O(LogN)