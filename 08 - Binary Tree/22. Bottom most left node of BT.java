class Solution {
    int urow = 0;
    int ucol = 0;
    int answer;
    public int findBottomLeftValue(TreeNode root) {
        answer = root.val;
        dfs(root, 0, 0);
        return answer;
    }
    public void dfs(TreeNode root, int row, int column){
        if(root == null){
            return;
        }
        dfs(root.left, row+1, column-1);
        if(row > urow && column <= ucol){
            answer = root.val;
            urow = row;
            ucol = column;
        }
        dfs(root.right, row+1, column+1);
        if(row > urow && column >= ucol){
            answer = root.val;
            urow = row;
            ucol = column;
        }
    }
}
// TC - O(N)
// SC - O(N) - for recursion