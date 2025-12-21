class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
       int[] ans = new int[2];
       ans[0] = 0;
       ans[1] = 0;
       for(int i = 0; i<mat.length; ++i){
        Arrays.sort(mat[i]);
        int low = 0;
        int high = mat[i].length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(mat[i][mid] == 1){
                int temp = mat[i].length-mid;
                if(temp > ans[1]){
                    ans[1] = temp;
                    ans[0] = i;
                }
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
       }
       return ans;
    }
}

// TC - O(mnLogn)
// SC - O(1)