import java.util.*;

public class Solution {
    ArrayList<Integer> boundaryTraversal(Node root){
        ArrayList<Integer> answer = new ArrayList<>();

        if(root == null){
            return answer;
        }
         answer.add(root.data);

        // left traversal
        leftDFS(root.left, answer);

        // leaf nodes
        leafDFS(root.left, answer);
        leafDFS(root.right, answer);

        // right traversal
        rightDFS(root.right, answer);
        return answer;
    }
    public void rightDFS(Node right, List<Integer> answer){
        if(right == null){
            return;
        }
        if(right.left == null && right.right == null){
            return;
        }
        else if(right.right != null){
            rightDFS(right.right, answer);
        }
        else{
            rightDFS(right.left, answer);
        }
        answer.add(right.data);
    }
    public void leafDFS(Node root, List<Integer> answer){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            answer.add(root.data);
            return;
        }
        leafDFS(root.left, answer);
        leafDFS(root.right, answer);
    }
    public void leftDFS(Node root, List<Integer> answer){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        answer.add(root.data);
        if(root.left != null){
            leftDFS(root.left, answer);
        }
        else{
            leftDFS(root.right, answer);
        }
    }
}

// TC - O(H)+O(H)+O(N) = O(N)
// SC - O(N)