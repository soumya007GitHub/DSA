class Solution {
    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    public Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            return new Info(
                true,
                Math.min(left.min, root.val),
                Math.max(right.max, root.val),
                sum
            );
        }
        return new Info(false, 0, 0, 0);
    }
}

// TC - O(N)
// SC - O(H)