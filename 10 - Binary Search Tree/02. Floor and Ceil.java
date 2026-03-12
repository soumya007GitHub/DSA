class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = -1;
        int ceil = -1;
        while(root != null){
            if(root.data == key){
                floor = root.data;
                ceil = root.data;
                break;
            }
            else if(root.data < key){
                floor = root.data;
                root = root.right;
            }else{
                ceil = root.data;
                root = root.left;
            }
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(floor);
        answer.add(ceil);
        return answer;
    }
}

// TC - O(logN)
// SC - O(1)