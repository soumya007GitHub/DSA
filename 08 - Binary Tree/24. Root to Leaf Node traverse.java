class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<String> answer = new ArrayList<>();
        dfs(root, q, answer);
        return answer;
    }
    public void dfs(TreeNode root, Deque<TreeNode> q, List<String> answer){
        if(root == null){
            return;
        }
        q.addLast(root);
        if(root.left == null && root.right == null){
            StringBuilder string = new StringBuilder();
            int size = q.size();
            for(int i = 1; i<=size; ++i){
                TreeNode current = q.removeFirst();
                string.append(current.val);
                if(i != size){
                    string.append("->");
                }
                q.addLast(current);
            }
            answer.add(string.toString());
            q.removeLast();
            return;
        }
        dfs(root.left, q, answer);
        dfs(root.right, q, answer);
        q.removeLast();
    }
}

// TC - O(N*N) - worst case
// SC - O(N)