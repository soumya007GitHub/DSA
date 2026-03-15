class Solution {
    public int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length <= 0){
            return null;
        }
        return bstConstructor(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode bstConstructor(int[] preorder, int min, int max){
        if(index >= preorder.length){
            return null;
        }
        if(preorder[index] <= min || preorder[index] >= max){
            return null;
        }
        TreeNode current = new TreeNode(preorder[index]);
            ++index;
        if(index < preorder.length && preorder[index] < current.val){
            current.left = bstConstructor(preorder, min, current.val);
        }
        if(index < preorder.length && preorder[index] > current.val){
            current.right = bstConstructor(preorder, current.val, max);
        }
        return current;
    }
}

// TC - O(N)
// SC - O(N)