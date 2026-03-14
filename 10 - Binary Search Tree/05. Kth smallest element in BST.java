class Solution {
    int counter = 0;
    int answer = -1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return answer;
    }
    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left, k);
        if(counter == k){
            return;
        }
        ++counter;
        answer = root.val;
        helper(root.right, k);
    }
}

// TC - O(N)
// SC - O(N)