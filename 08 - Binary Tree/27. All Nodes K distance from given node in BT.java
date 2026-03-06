class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null){
            return new ArrayList<>();
        }
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i<=size; ++i){
                TreeNode current = q.remove();
                if(current.left != null){
                    q.add(current.left);
                    parent.put(current.left, current);
                }
                if(current.right != null){
                    q.add(current.right);
                    parent.put(current.right, current);
                }
            }
        }
        q = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int counter = 0;
        while(!q.isEmpty() && counter != k){
            int size = q.size();
            for(int i = 1; i<=size; ++i){
                TreeNode current = q.remove();
                if(!set.contains(current)){
                    set.add(current);
                }
                TreeNode par = parent.get(current);
                if(par != null && !set.contains(par)){
                    set.add(par);
                     q.add(par);
                }
                if(current.left != null && !set.contains(current.left)){
                    set.add(current.left);
                    q.add(current.left);
                }
                if(current.right != null && !set.contains(current.right)){
                    set.add(current.right);
                    q.add(current.right);
                }
            }
            ++counter;
        }
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            answer.add(q.remove().val);
        }
        return answer;
    }
}

// TC - O(N)
// SC - O(N)