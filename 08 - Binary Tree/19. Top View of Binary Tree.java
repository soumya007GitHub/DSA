class Solution {
    public List<Integer> topView(TreeNode root) {
       if(root == null){
        return new ArrayList<>();
       }
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(root, 0));
       TreeMap<Integer, TreeNode> map = new TreeMap<>();
       while(!q.isEmpty()){
        Pair current = q.remove();
        if(!map.containsKey(current.column)){
            map.put(current.column, current.node);
        }
        if(current.node.left != null){
            q.add(new Pair(current.node.left, current.column-1));
        }
        if(current.node.right != null){
            q.add(new Pair(current.node.right, current.column+1));
        }
       }
       List<Integer> answer = new ArrayList<>();
       for(Map.Entry<Integer, TreeNode> entry: map.entrySet()){
        answer.add(entry.getValue().data);
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

// TC - O(N)logN = O(N) = for tree traversal using BFS and LogN for treemap
// SC - O(N) = for using queue