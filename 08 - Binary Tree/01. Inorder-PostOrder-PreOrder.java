class Solution {
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node = node;
            this.num = num;
        }
    }
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> answer = new ArrayList<>();
        while(!stack.isEmpty()){
            Pair now = stack.pop();
            if(now.num == 1){
                preOrder.add(now.node.data);
                ++now.num;
                stack.push(now);
                if(now.node.left != null){
                    stack.push(new Pair(now.node.left, 1));
                }
            }
            else if(now.num == 2){
                inOrder.add(now.node.data);
                ++now.num;
                stack.push(now);
                if(now.node.right != null){
                    stack.push(new Pair(now.node.right, 1));
                }
            }
            else{
                postOrder.add(now.node.data);
            }
        }
        answer.add(inOrder);
        answer.add(preOrder);
        answer.add(postOrder);
        return answer;
    }
}

// TC - O(3N) - N = number of nodes in binary tree, 3 bcz for each node we are incrementing till 3 so for each node 3 times popping and pushing into the stack.
// SC - O(4N) - 3N for preorder, inorder, postorder list and another N for stack.