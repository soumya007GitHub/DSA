class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
             if(!stack.isEmpty()){
                if(stack.peek() == '(' && ch == ')'){
                    stack.pop();
                    continue;
                }
                else if(stack.peek() == '{' && ch == '}'){
                    stack.pop();
                    continue;
                }
                else if(stack.peek() == '[' && ch == ']'){
                    stack.pop();
                    continue;
                }
             }
             stack.push(ch);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}

// TC - O(N)
// SC - O(N)