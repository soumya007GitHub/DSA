class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode lastNode = root.left;
            while(lastNode.right != null){
                lastNode = lastNode.right;
            }
            lastNode.right = root.right;
            root.right = null;
            return root.left;
        }
        return root;
    }
}

// TC - O(h)
// SC - O(h)