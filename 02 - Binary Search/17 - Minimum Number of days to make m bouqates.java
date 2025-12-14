class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length/k < m){
            return -1;
        }
        int low = 1;
        int high = 1;
        int ans = -1;
        for(int i = 0; i<bloomDay.length; ++i){
            high = Math.max(high, bloomDay[i]);
        }
        while(low<=high){
            int mid = (low+high)/2;
            int count = 0;
            int total = 0;
            for(int i = 0; i<bloomDay.length; ++i){
                if (bloomDay[i] <= mid) {
                    count++;
                } else {
                   count = 0;
                }
                if(count == k){
                    ++total;
                    count = 0;
                }
            }
            if(total >= m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

// Time Complexity: O(n log max(bloomDay))
// Space Complexity: O(1)