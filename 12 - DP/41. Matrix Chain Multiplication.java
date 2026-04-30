class Solution {
    public int matrixMultiplication(int arr[]) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 0; i<arr.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, 1, arr.length - 1, dp);
    }

    public int helper(int arr[], int start, int end, int[][] dp) {
        if (start == end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        int min = Integer.MAX_VALUE;

        for (int k = start; k < end; ++k) {
            int cost1 = helper(arr, start, k, dp);
            int cost2 = helper(arr, k + 1, end, dp);
            int cost3 = arr[start - 1] * arr[k] * arr[end];

            int totalCost = cost1 + cost2 + cost3;
            min = Math.min(min, totalCost);
        }
        dp[start][end] = min;
        return dp[start][end];
    }
}

// tc - O(m*m*m)
// sc - O(m*m)