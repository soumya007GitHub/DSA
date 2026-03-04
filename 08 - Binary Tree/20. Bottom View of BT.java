class Solution {
    public List<Integer> bottomView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair current = q.remove();
            map.put(current.column, current.node.data);
            if(current.node.left != null){
                q.add(new Pair(current.node.left, current.column-1));
            }
            if(current.node.right != null){
                q.add(new Pair(current.node.right, current.column+1));
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
    public class Pair{
        TreeNode node;
        int column;
        Pair(TreeNode node, int column){
            this.node = node;
            this.column = column;
        }
    }
}
// TC - O(NlogN)
// SC - O(N)