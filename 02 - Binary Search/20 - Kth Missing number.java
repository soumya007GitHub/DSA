class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if((arr[mid] - (mid+1))<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low + k;
    }
}

// Step 1
// Finding out all missing numbers at all indexes
// based on the missing number we decide our given missing number falls between which two indexes.

// Step 2
// Based on binary custom search algo
// Answer will be always be equal to - (low+k)

// TC - O(logN)
// SC - O(1)