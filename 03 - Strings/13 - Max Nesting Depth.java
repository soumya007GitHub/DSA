class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                ++count;
                maxDepth = Math.max(maxDepth, count);
            }
            else if(ch == ')'){
                --count;
            }else{
                continue;
            }
        }
        return maxDepth;
    }
}

// TC - O(n)
// SC - O(1)