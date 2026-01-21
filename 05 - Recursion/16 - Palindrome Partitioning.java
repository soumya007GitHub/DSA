class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), answer);
        return answer;
    }
    public void helper(String s, int start, List<String> piece, List<List<String>> answer){
        if (start == s.length()) {
            answer.add(new ArrayList<>(piece));
            return;
        }
        for (int i = start; i < s.length(); ++i){
            String word = s.substring(start, i + 1);
            if (isPalindrome(word)){
            piece.add(word);
            helper(s, i + 1, piece, answer);
            piece.remove(piece.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String word){
        int i = 0;
        int j = word.length()-1;
        while(i<j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}