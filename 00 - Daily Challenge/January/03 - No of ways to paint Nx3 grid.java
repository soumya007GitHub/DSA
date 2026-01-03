class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long ways1 = 6;
        long ways2 = 6;
        for(int i = 2; i<=n; ++i){
            long newAba = (ways1 * 2 + ways2 * 2) % MOD;
            long newAbc = (ways1 * 2 + ways2 * 3) % MOD;

            ways1 = newAba;
            ways2 = newAbc;

        }
         return (int)((ways1 + ways2) % MOD);
    }
}
// TC - O(N)
// SC - O(1)