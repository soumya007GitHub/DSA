class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; ++i){
                TreeNode current = q.remove();
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
                inner.add(current.val);
            }
            outer.add(inner);
            inner = new ArrayList<>();
        }
        return outer;
    }
}
// Time Complexity: O(n) for each node we are running a loop to add left and right nodes if present
// Space Complexity: O(n) queue will store each node