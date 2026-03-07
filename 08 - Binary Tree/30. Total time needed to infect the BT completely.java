class Solution {
    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = null;
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i<=size; ++i){
                TreeNode current = q.remove();
                if(current.val == start){
                    target = current;
                }
                if(current.left != null){
                    q.add(current.left);
                    map.put(current.left, current);
                }
                if(current.right != null){
                    q.add(current.right);
                    map.put(current.right, current);
                }
            }
        }
        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);

        q = new LinkedList<>();
        q.add(target);

        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i<=size; ++i){
                TreeNode current = q.remove();
                if(map.containsKey(current) && !set.contains(map.get(current))){
                    q.add(map.get(current));
                }
                if(current.left != null && !set.contains(current.left)){
                    q.add(current.left);
                }
                if(current.right != null && !set.contains(current.right)){
                    q.add(current.right);
                }
                if(!set.contains(current)){
                    set.add(current);
                }
            }
            ++count;
        }
        return count-1;
    }
}

// TC - O(N)
// SC - O(N)