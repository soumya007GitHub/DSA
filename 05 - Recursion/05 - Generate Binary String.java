class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> answer = new ArrayList<>();
        String word = "";
        helper(n, word, answer);
        return answer;
    }
    public void helper(int n, String word, List<String> answer){
        if(word.length() == n){
            answer.add(word);
            return;
        }
        helper(n, word+'0', answer);
        if(word.length() <= 0 || word.charAt(word.length()-1) == '0'){
            helper(n, word+'1', answer);
        }
    }
}

// TC - O(2^N)
// SC - O(N)