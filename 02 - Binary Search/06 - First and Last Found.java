class Solution {
    public int[] searchRange(int[] arr, int x) {
        int start = 0;
       int end = arr.length-1;
       int[] ans = new int[2];
       ans[0] = -1;
       ans[1] = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == x){
                ans[0] = mid;
                end = mid-1;
            }
            else if(arr[mid] < x){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        start = 0;
        end = arr.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == x){
                ans[1] = mid;
                start = mid+1;
            }
            else if(arr[mid] > x){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}

// TC - O(LogN) 
// SC - O(1)