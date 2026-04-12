class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    public int helper(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int notsteal = helper(root.left, map) + helper(root.right, map);
        int steal = root.val;
        if(root.left != null){
            steal += (helper(root.left.left, map)+helper(root.left.right, map));
        }
        if(root.right != null){
            steal += (helper(root.right.left, map) + helper(root.right.right, map));
        }

        map.put(root, Math.max(steal, notsteal));
        return Math.max(steal, notsteal);
    }
}

// TC - O(n)
// SC - o(n)
// n - total number of nodes in BT