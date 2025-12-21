class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int lowCol = 0;
        int highCol = mat[0].length-1;
        while(lowCol <= highCol){
            int midCol = (lowCol+highCol)/2;
            int maxElement = mat[0][midCol];
            int row = 0;
            for(int i = 1; i<mat.length; ++i){
                if(mat[i][midCol] > maxElement){
                    maxElement = mat[i][midCol];
                    row = i;
                }
            }
            int left = midCol > 0 ? mat[row][midCol - 1] : -1;
            int right = midCol < mat[0].length-1 ? mat[row][midCol+1] : -1;
            if(maxElement > left && maxElement > right){
                return new int[]{row, midCol};
            }
            if(maxElement < left){
                highCol = midCol-1;
            }else{
                lowCol = midCol+1;
            }
        }
        return new int[]{0, 0};
    }
}

// TC - O(mLogn)
// SC - O(1)