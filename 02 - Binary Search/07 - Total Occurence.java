class Solution {
    public int countOccurrences(int[] arr, int x) {
        int count = 0;
       int start = 0;
       int end = arr.length-1;
       int last = -1;
       int first = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == x){
                first = mid;
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
                last = mid;
                start = mid+1;
            }
            else if(arr[mid] > x){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return last-first+1;
    }
}
// TC - O(logN)
// SC - O(1)