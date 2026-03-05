
class Solution {
    class Pair{
        TreeNode node;
        long index;
        public Pair(TreeNode node, long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().index;
            long last = first;

            for(int i = 1; i<=size; ++i){
                Pair current = q.remove();
                last = Math.max(last, current.index);
                if(current.node.left != null){
                    q.add(new Pair(current.node.left, 2*current.index));
                }
                if(current.node.right != null){
                    q.add(new Pair(current.node.right, 2*current.index+1));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}

// TC - O(N)
// SC - O(N)