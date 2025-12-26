class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String answer = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // Odd-length palindrome (center at i)
            String odd = expandAroundCenter(s, i, i);

            // Even-length palindrome (center between i and i+1)
            String even = expandAroundCenter(s, i, i + 1);

            // Choose the longer one
            if (odd.length() > answer.length()) answer = odd;
            if (even.length() > answer.length()) answer = even;
        }

        return answer;
    }
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Substring after breaking loop: (left+1, right)
        return s.substring(left+1, right);
    }
}

// TC - O(N^2)
// SC - O(1)