class Solution {
    public int findMedian(int[][] matrix) {
      int low = matrix[0][0];
      int high = matrix[matrix.length-1][matrix[0].length-1];
      for(int i = 0; i<matrix.length; ++i){
        low = Math.min(low, matrix[i][0]);
        high = Math.max(high, matrix[i][matrix[i].length-1]);
      }
      int totalOnLeft = (matrix.length*matrix[0].length)/2;
      while(low <= high){
        int mid = (low+high)/2;
        int count = 0;
        for(int row = 0; row<matrix.length; ++row){
                int lowI = 0;
                int highI = matrix[0].length-1;
                while(lowI <= highI){
                int midI = (lowI+highI)/2;
                if(matrix[row][midI] <= mid){
                        lowI = midI+1;
                }
                else{
                        highI = midI-1;
                }
                }
                count += lowI;
        }
        if(count <= totalOnLeft){
                low = mid+1;
        }else{
                high = mid-1;
        }
      }
      return low;
    }
}

// TC - O(m*log(high-low)*log(n))
// SC - O(1)