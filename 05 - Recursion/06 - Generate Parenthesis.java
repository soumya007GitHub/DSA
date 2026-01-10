class Solution {
    public List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        ++left;
        String word = "(";
        List<String> answer = new ArrayList<>();
        helper(left, right, n, word, answer);
        return answer;
    }
    public void helper(int left, int right, int n, String word, List<String> answer){
        if(left < n){
            helper(left+1, right, n, word+'(', answer);
        }
        if(right < n && right < left){
            helper(left, right+1, n, word+')', answer);
        }
        
        if(left == n && right == n){
            answer.add(word);
            return;
        }
    }
}

// TC - O(4^N)
// SC - O(N)