class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < asteroids.length; ++i){
            
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }
            else{
                boolean destroyed = false;
                
                while(!stack.isEmpty() && stack.peek() > 0){
                    
                    if(stack.peek() < Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    else if(stack.peek() == Math.abs(asteroids[i])){
                        stack.pop();
                        destroyed = true;
                        break;
                    }
                    else{
                        destroyed = true;
                        break;
                    }
                }
                
                if(!destroyed){
                    stack.push(asteroids[i]);
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; --i){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}


// TC - O(N)
// SC - O(N)