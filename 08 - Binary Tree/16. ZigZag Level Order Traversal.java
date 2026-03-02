class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> dq = new LinkedList<>();
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean orderReverse = true;
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size = dq.size();
                for(int i = 1; i<=size; ++i){
                    TreeNode current = orderReverse ? dq.removeFirst() : dq.removeLast();
                    if(orderReverse){
                        if(current.left != null){
                            dq.addLast(current.left);
                        }
                        if(current.right != null){
                            dq.addLast(current.right);
                        }
                    }else{
                        if(current.right != null){
                            dq.addFirst(current.right);
                        }
                        if(current.left != null){
                            dq.addFirst(current.left);
                        }
                    }
                    inner.add(current.val);
                }
            outer.add(inner);
            inner = new ArrayList<>();
            orderReverse = !orderReverse;
        }
        return outer;
    }
}

// TC - O(N)
// SC - O(N)