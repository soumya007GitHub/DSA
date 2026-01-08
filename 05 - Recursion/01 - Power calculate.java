class Solution {
    public double myPow(double x, int n) {
        long N = (long)n;
        if(N < 0){
            x = 1/x;
            N = -n;
        }
        return compute(x, N);
    }
    
public double compute(double x, long N){
    if(N == 0){
            return 1;
        }
        if(N == 1){
            return x;
        }
        double front = compute(x, N/2);
        double next = front*front;
        if(N%2 != 0){
            next *= x;
        }
        return next;
}
}

// TC - O(logN)
// SC - O(logN)