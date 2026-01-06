class Solution {
    Queue<TreeNode> q = new LinkedList<>();
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        q.add(root);
        q.add(null);
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int answerLevel = 1;
        int tempSum = 0;

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp != null){
                tempSum += temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            else{
                if(tempSum > maxSum){
                    maxSum = tempSum;
                    answerLevel = level;
                }
                ++level;
                tempSum = 0;
                if(q.isEmpty()) break;
                else q.add(null);
            }
        }
        return answerLevel;
    }
}

// TC - O(N)
// SC - O(N)