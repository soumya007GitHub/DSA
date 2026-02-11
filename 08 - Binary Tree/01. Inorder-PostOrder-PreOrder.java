
class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        if(root == null){
            return outer;
        }
        // In-order
        inorder(inner, root);
        outer.add(inner);
        inner =  new ArrayList<>();
        // Pre-order
        preorder(inner, root);
        outer.add(inner);
        inner =  new ArrayList<>();
        // Post-order
        postorder(inner, root);
        outer.add(inner);

        return outer;
    }
    public void inorder(List<Integer> inner, TreeNode root){
        if(root == null){
            return;
        }
        inorder(inner, root.left);
        inner.add(root.data);
        inorder(inner, root.right);
        return;
    }
    public void preorder(List<Integer> inner, TreeNode root){
        if(root == null){
            return;
        }
        inner.add(root.data);
        preorder(inner, root.left);
        preorder(inner, root.right);
        return;
    }
    public void postorder(List<Integer> inner, TreeNode root){
        if(root == null){
            return;
        }
        postorder(inner, root.left);
        postorder(inner, root.right);
        inner.add(root.data);
        return;
    }
}

// TC - O(N) - N - number of nodes
// SC - O(H) - H - height of tree (recursive stack)