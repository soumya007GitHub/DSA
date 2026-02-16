class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] NSE = new int[heights.length];
        int[] PSE = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        // NSE
        for(int i = heights.length-1; i>=0; --i){
            if(stack.isEmpty()){
                NSE[i] = heights.length;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    NSE[i] = heights.length;
                }
                else{
                    NSE[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        stack = new Stack<>();
        // PSE
        for(int i = 0; i<heights.length; ++i){
            if(stack.isEmpty()){
                PSE[i] = -1;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    PSE[i] = -1;
                }else{
                    PSE[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        int max = 0;
        for(int i = 0; i<heights.length; ++i){
            int distance = NSE[i]-PSE[i]-1;
            max = Math.max(max, heights[i]*distance);
        }
        return max;
    }
}