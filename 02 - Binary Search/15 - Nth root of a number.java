class Solution {
    public int NthRoot(int N, int M) {
        int low = 1;
        int high = M;
        while(low<=high){
            int mid = (low+high)/2;
            int temp = 1;
            for(int i = 1; i<=N; ++i){
                temp = temp*mid;
            }
            if(temp == M){
                return mid;
            }
            else if(temp < M){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}


// TC - O(NlogM)
// SC - O(1)