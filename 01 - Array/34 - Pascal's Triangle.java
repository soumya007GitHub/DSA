class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> outer = new ArrayList<>();
        for(int i = 0; i<numRows; ++i){
            List<Integer> previous = null;
            if(i != 0){
             previous = outer.get(i-1);
            }
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j<=i; ++j){
                if(j == 0 || j == i){
                    inner.add(1);
                }else{
                    inner.add(previous.get(j-1)+previous.get(j));
                }
            }
            outer.add(inner);
        }
        return outer;
    }
}

// TC - O(N*N)
// SC - O(N)