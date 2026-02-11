class Solution {
    public int trap(int[] height) {
        int leftBoundary[] = new int[height.length];
        int rightBoundary[] = new int[height.length];
        leftBoundary[0] = height[0];
        rightBoundary[height.length-1] = height[height.length-1];
        int total = 0;
        for(int i = 1; i<height.length; ++i){
            if(height[i] < leftBoundary[i-1]){
                leftBoundary[i] = leftBoundary[i-1];
            }
            else{
                leftBoundary[i] = height[i];
            }
        }
        
        for(int i = height.length-2; i>=0; --i){
            if(height[i] < rightBoundary[i+1]){
                rightBoundary[i] = rightBoundary[i+1];
            }
            else{
                rightBoundary[i] = height[i];
            }
        }
        for(int i = 0; i<height.length; ++i){
            int min = Math.min(leftBoundary[i], rightBoundary[i]);
            total = total + (min-height[i]);
        }
        return total;
    }
}

// TC - O(N)
// SC - O(N)