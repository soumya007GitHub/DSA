class Solution {
    public int[] nextSmallerElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[arr.length];
        for(int i = arr.length-1; i>=0; --i){
            if(stack.isEmpty()){
                answer[i] = -1;
            }
            else if(!stack.isEmpty()){
                if(stack.peek() < arr[i]){
                    answer[i] = stack.peek();
                }else{
                    while(!stack.isEmpty() && stack.peek() >= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()){
                        answer[i] = stack.peek();
                    }
                    else{
                        answer[i] = -1;
                    }
                }
            }
            stack.push(arr[i]);
        }
        return answer;
    }
}

// TC - O(N)
// SC - O(N)