class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;
        if(m > n){
            return kthElement(b, a, k);
        }
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) l1 = a[mid1-1];
            if(mid2 - 1 >= 0) l2 = b[mid2-1];
            if(mid1 < m) r1 = a[mid1];
            if(mid2 < n) r2 = b[mid2];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }
}

// TC - O(log(Min(m, n)))
// SC - O(1)