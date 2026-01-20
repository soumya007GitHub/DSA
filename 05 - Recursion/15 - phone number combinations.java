class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
         if (digits.length() == 0) return answer;

        int k = digits.length();
        String[] chars = new String[8];
        chars[0] = "abc";
        chars[1] = "def";
        chars[2] = "ghi";
        chars[3] = "jkl";
        chars[4] = "mno";
        chars[5] = "pqrs";
        chars[6] = "tuv";
        chars[7] = "wxyz";
        helper("", 0, digits, chars, answer);
        return answer;
    }
    public void helper(String inner, int index, String digits, String[] chars, List<String> answer){
        if (index == digits.length()) {
            answer.add(inner);
            return;
        }
        int digit = digits.charAt(index) - '2';
        String letters = chars[digit];
         for (int i = 0; i < letters.length(); i++) {
            helper(inner + letters.charAt(i), index + 1, digits, chars, answer);
        }
    }
}
