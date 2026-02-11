 import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 0){
            if(queue.peek() != null){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                inner.add(queue.remove().val);
            }
            else{
                queue.remove();
                outer.add(inner);
                inner = new ArrayList<>();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
        }
        Collections.reverse(outer);
        return outer;
    }
}

// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(n) where n is the number of nodes in the tree