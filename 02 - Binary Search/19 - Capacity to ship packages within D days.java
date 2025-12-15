class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        for (int i = 1; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
        }
        int high = weights[0];
        for(int i = 1; i<weights.length; ++i){
            high += weights[i];
        }
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int count = 1;
            int sum = 0;
            for(int i = 0; i<weights.length; ++i){
                if(sum + weights[i] <= mid){
                sum += weights[i];
                }else{
                    sum = weights[i];
                    ++count;
                }
            }
            if(count <= days){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

// TC - O(N) + O(Nlog(Sum(weights)))
// SC - O(1)