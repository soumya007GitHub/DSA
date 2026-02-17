class Solution {
    public int celebrity(int[][] M) {
      int n = M.length;
      int top = 0;
      int down = n-1;
      int candidate = -1;
      while(top <= down){
        if(M[top][down] == 1){
            ++top;
        }else{
            --down;
        }
      }
      candidate = top;
      for(int i = 0; i<n; ++i){
        if(i == candidate){
            continue;
        }
        else if(M[candidate][i] == 1 || M[i][candidate] == 0){
            return -1;
        }
      }
      return candidate;
    }
}

// TC - O(n)
// SC - O(1)