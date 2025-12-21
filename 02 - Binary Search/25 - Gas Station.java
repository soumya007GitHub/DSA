class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        double low = 0;
        double high = arr[0];
        for(int i = 1; i<arr.length; ++i){
            high = Math.max(high, arr[i]-arr[i-1]);
        }
        while(high - low > 1e-6){
            double mid = (low+high)/2.0;
            int count = 0;
            for(int i = 1; i<arr.length; ++i){
                count = count + (int)((arr[i] - arr[i - 1])/mid);
            }
            if(count <= k){
                high = mid;
            }else{
                low = mid;
            }
        }
        return high;
    }
}

// TC - O(Nlog(Max Difference))
// SC - O(1)