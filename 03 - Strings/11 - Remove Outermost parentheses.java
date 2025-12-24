class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i) == '('){
                if(depth > 0){
                    answer.append('(');
                }
                ++depth;
            }else{
                if(depth > 1){
                    answer.append(')');
                }
                --depth;
            }
        }
        return answer.toString();
    }
}

// TC - O(N)
// SC - O(N)