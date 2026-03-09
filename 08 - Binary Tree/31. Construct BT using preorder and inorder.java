class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return treeBuild(0, preorder.length-1, preorder,
                         0, inorder.length-1, inorder, inMap);
    }

    public TreeNode treeBuild(int startPre, int endPre, int[] preorder,
                              int startIn, int endIn, int[] inorder,
                              HashMap<Integer, Integer> inMap){

        if(startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);

        int inRoot = inMap.get(preorder[startPre]);

        int leftSize = inRoot - startIn;

        root.left = treeBuild(startPre+1, startPre+leftSize, preorder,
                              startIn, inRoot-1, inorder, inMap);

        root.right = treeBuild(startPre+leftSize+1, endPre, preorder,
                               inRoot+1, endIn, inorder, inMap);

        return root;
    }
}

// TC - O(N)
// SC - O(N)