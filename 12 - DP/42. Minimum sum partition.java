class Solution {
    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int num:arr) sum+=num;
        int[][] dp = new int[n+1][(sum/2)+1];
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<=n; ++i){
            for(int j = 1; j<=(sum/2); ++j){
                if(arr[i-1] <= j){
                    int take = arr[i-1] + dp[i-1][j-arr[i-1]];
                    int notTake = dp[i-1][j];
                    dp[i][j] = Math.max(take, notTake);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                int set1 = dp[i][j];
                int set2 = sum - set1;
                answer = Math.min(answer, Math.abs(set1-set2));
            }
        }
        return answer;
    }
}


// tc = sc = o(n*n)