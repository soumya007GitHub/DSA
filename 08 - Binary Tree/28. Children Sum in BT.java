class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i<=size; ++i){
            TreeNode current = q.remove();
            int left = 0;
            if(current.left != null){
                left = current.left.val;
                q.add(current.left);
            }
            int right = 0;
            if(current.right != null){
                right = current.right.val;
                q.add(current.right);
            }
            if(current.left != null || current.right != null){
               if(left+right != current.val){
                return false;
               }
            }
            }
        }
        return true;
    }
}
// TC - O(N)
// SC - O(N)