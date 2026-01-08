class Solution {
    final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd  = n / 2;

        long evenProduct = helper(5, even);
        long oddProduct = helper(4, odd);
        long answer = evenProduct*oddProduct;
        // Answer = 5^even * 4^odd
        return (int)((evenProduct * oddProduct) % MOD);
    }
    public long helper(long base, long power){
        if(power == 0){
            return 1;
        }
        if(power == 1){
            return base;
        }
        long next = helper(base, power/2);
        next = (next*next)%MOD;
        if(power%2 == 1){
            next *= base;
            next = next%MOD;
        }
        return next;
    }
}


// TC - O(logN)
// SC - O(logN)