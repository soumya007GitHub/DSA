// Recursive Solution - top down approach
class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        return helper(n, dp);
    }
    public int helper(int n, int[] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = helper(n-1, dp) + helper(n-2, dp);
        return dp[n];
    }
}
// TC - O(N)
// SC - O(N)


// Tabulation Solution - bottom up approach
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; ++i){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// TC - O(N)
// SC - O(N)



// More optimised solution
class Solution {
    public int fib(int n) {
       if(n <= 1){
        return n;
       }
       int first = 0;
       int second = 1;
       for(int i = 2; i<=n; ++i){
        int temp = first+second;
        first = second;
        second = temp;
       }
       return second;
    }
}
// TC - O(N)
// SC - O(1)
