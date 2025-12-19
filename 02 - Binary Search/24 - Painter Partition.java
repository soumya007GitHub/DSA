class Solution {
    public int paint(int A, int B, int[] C) {
        if(A > C.length){
            int ans = C[0];
            for(int i = 1; i<C.length; ++i){
                ans = Math.max(ans, C[i]*B);
            }
            return ans;
        }
        int low = C[0];
        int high = C[0];
        for(int i = 1; i<C.length; ++i){
            low = Math.max(low, C[i]*B);
            high += C[i]*B;
        }
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            int count = 1;
            int sum = 0;
            for(int i = 0; i<C.length; ++i){
                if(sum + (B*C[i])<=mid){
                    sum += B*C[i];
                }else{
                    ++count;
                    sum = B*C[i];
                }
            }
            if(count <= A){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

// TC - O(N*log(SumOfAllBoards))
// SC - O(1)