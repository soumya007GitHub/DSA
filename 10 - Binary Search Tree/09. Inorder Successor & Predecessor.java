class Solution {
    public int predecessor = -1;
    public int successor = -1;

    List<Integer> succPredBST(TreeNode root, int key) {
        predecessorFinder(root, key);
        successorFinder(root, key);

        List<Integer> answer = new ArrayList<>();
        answer.add(predecessor);
        answer.add(successor);
        return answer;
    }

    public void predecessorFinder(TreeNode root, int key){
        TreeNode temp = root;
        while(temp != null){
            if(temp.data < key){
                predecessor = temp.data;
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
    }

    public void successorFinder(TreeNode root, int key){
        TreeNode temp = root;
        while(temp != null){
            if(temp.data > key){
                successor = temp.data;
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
    }
}
// TC - O(H)
// SC - O(1)