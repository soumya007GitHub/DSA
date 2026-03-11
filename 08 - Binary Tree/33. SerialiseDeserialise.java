public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode current = q.remove();
            if(current == null){
                sb.append('@');
                if(q.size() != 0){
                    sb.append(",");
                }
            }
            else{
                q.add(current.left);
                q.add(current.right);
                sb.append(current.val);
                if(q.size() != 0){
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int current = 1;
        while(!q.isEmpty() && current <nodes.length){
            TreeNode now = q.remove();
            if(!nodes[current].equals("@")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[current]));
                now.left = left;
                q.add(left);
            }
            ++current;
            if(current < nodes.length && !nodes[current].equals("@")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[current]));
                now.right = right;
                q.add(right);
            }
            ++current;
        }
        return root;
    }
}

// TC - O(N)
// SC - O(N)