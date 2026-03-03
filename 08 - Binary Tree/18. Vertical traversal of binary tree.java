class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        // treemap(column, treemap(level, list))
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> treemap = new TreeMap<>();
        dfs(root, 0, 0, treemap);
        List<List<Integer>> answer = new ArrayList<>();
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry: treemap.entrySet()){
            List<Integer> columnList = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry2 : entry.getValue().entrySet()){
                Collections.sort(entry2.getValue());
                columnList.addAll(entry2.getValue());
            }
            answer.add(columnList);
        }
        return answer;
    }
    public void dfs(TreeNode root, int column, int level, TreeMap<Integer, TreeMap<Integer, List<Integer>>> treemap){
        if(root == null){
            return;
        }
        if(!treemap.containsKey(column)){
            treemap.put(column, new TreeMap<>());
        }
        if(!treemap.get(column).containsKey(level)){
            treemap.get(column).put(level, new ArrayList<>());
        }
        treemap.get(column).get(level).add(root.val);
        dfs(root.left, column-1, level+1, treemap);
        dfs(root.right, column+1, level+1, treemap);
    }
}

// TC - O(N)LogN - N for traversal of nodes and logN for sorting
// SC - O(N)