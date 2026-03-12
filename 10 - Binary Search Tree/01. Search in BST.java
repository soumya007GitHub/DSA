class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode answer;
        if(root.val < val){
            answer = searchBST(root.right, val);
        }else{
            answer = searchBST(root.left, val);
        }
        return answer;
    }
}

// TC - O(logN)
// SC - O(1)