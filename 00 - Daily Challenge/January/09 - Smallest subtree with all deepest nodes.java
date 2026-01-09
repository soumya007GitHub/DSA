class Solution {
    TreeNode ans = null;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private int dfs(TreeNode node, int depth) {
        if (node == null) return depth;

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);

        int currDepth = Math.max(left, right);

        if (left == right && currDepth >= maxDepth) {
            maxDepth = currDepth;
            ans = node;
        }

        return currDepth;
    }
}