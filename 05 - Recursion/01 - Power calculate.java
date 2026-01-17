class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                return 1/(x*myPow(x, -(n+1)));
            }
            return 1/(myPow(x, -n));
        }
        double next = myPow(x, n/2);
        next = next*next;
        if(n%2 != 0){
            next = next*x;
        }
        return next;
    }
}

// TC - O(logN)
// SC - O(logN)