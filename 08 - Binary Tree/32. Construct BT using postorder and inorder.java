import java.util.*;

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return treeBuild(0, postorder.length - 1, postorder,
                         0, inorder.length - 1, inorder, inMap);
    }

    public TreeNode treeBuild(int startPost, int endPost, int[] postorder,
                              int startIn, int endIn, int[] inorder,
                              HashMap<Integer, Integer> inMap){

        if(startPost > endPost || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(postorder[endPost]);

        int inRoot = inMap.get(postorder[endPost]);

        int leftSize = inRoot - startIn;

        root.left = treeBuild(
                startPost,
                startPost + leftSize - 1,
                postorder,
                startIn,
                inRoot - 1,
                inorder,
                inMap
        );

        root.right = treeBuild(
                startPost + leftSize,
                endPost - 1,
                postorder,
                inRoot + 1,
                endIn,
                inorder,
                inMap
        );

        return root;
    }
}

// TC - O(N)
// SC - O(N)