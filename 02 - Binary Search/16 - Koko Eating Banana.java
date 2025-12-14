class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        int ans = -1;
        for(int i = 0; i<piles.length; ++i){
            high = Math.max(high, piles[i]);
        }
        while(low <= high){
            int mid = (low+high)/2;
            int temp = 0;
            for(int i = 0; i<piles.length; ++i){
                temp += Math.ceil((double)piles[i]/mid);
            }
            if(temp <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}


// TC - O(nlogh)
// SC - O(1)