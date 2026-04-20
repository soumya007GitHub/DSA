// Recursion 
// TC = O(2^(m+n))
// SC = O(m+n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1.length()-1, text2.length()-1, text1, text2);
    }
    public int helper(int m, int n, String text1, String text2){
        if(m < 0 || n < 0) return 0;
        if(text1.charAt(m) == text2.charAt(n)){
            return 1+helper(m-1, n-1, text1, text2);
        }else{
            return Math.max(helper(m-1, n, text1, text2), helper(m, n-1, text1, text2));
        }
    }
}


// Using memoization
// TC - O(M*N)
// SC = O(M*N)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(text1.length()-1, text2.length()-1, text1, text2, dp);
    }
    public int helper(int m, int n, String text1, String text2, int[][] dp){
        if(m < 0 || n < 0) return 0;
        else if(dp[m][n] != -1) return dp[m][n];
        else if(text1.charAt(m) == text2.charAt(n)){
            dp[m][n] =  1+helper(m-1, n-1, text1, text2, dp);
        }else{
            dp[m][n] = Math.max(helper(m-1, n, text1, text2, dp), helper(m, n-1, text1, text2, dp));
        }
        return dp[m][n];
    }
}

// Tabulation
// TC = SC = O(M*N)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m; ++i){
            for(int j = 1; j<=n; ++j){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}