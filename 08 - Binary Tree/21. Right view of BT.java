class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair current = q.remove();
            map.put(current.row, current.node.val);
            if(current.node.left != null){
                q.add(new Pair(current.row+1, current.node.left));
            }
            if(current.node.right != null){
                q.add(new Pair(current.row+1, current.node.right));
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
    public class Pair{
        int row;
        TreeNode node;
        Pair(int row, TreeNode node){
            this.row = row;
            this.node = node;
        }
    }
}

// TC - O(NlogN)
// SC - O(N)