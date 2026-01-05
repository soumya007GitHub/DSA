class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negCount = 0;
        long leastNumber = Long.MAX_VALUE;
        long sum = 0;
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<matrix.length; ++j){
                leastNumber = Math.min(leastNumber, Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0){
                    ++negCount;
                }
                sum += Math.abs(matrix[i][j]);
            }
        }
        
        if(negCount%2 == 0){
            return sum;
        }
        return sum-(leastNumber*2);
    }
}

// TC - O(N*N)
// SC - O(1)