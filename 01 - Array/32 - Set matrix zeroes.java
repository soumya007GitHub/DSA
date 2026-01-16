class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rowMarker = new boolean[matrix.length];
        boolean[] columnMarker = new boolean[matrix[0].length];
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<matrix[i].length; ++j){
                if(matrix[i][j] == 0){
                    rowMarker[i] = true;
                    columnMarker[j] = true;
                }
            }
        }
        for(int i = 0; i<rowMarker.length; ++i){
            if(rowMarker[i]){
                for(int j = 0; j<matrix[i].length; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i<columnMarker.length; ++i){
            if(columnMarker[i]){
                for(int j = 0; j<matrix.length; ++j){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}

// TC - O(M*N)
// SC - O(M+N)