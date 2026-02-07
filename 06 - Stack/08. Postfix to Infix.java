class Solution {
    public String postToInfix(String postExp) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < postExp.length()){
            char ch = postExp.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                String s = "" + ch;
                stack.push(s);
            }else{
                String secondOperand = stack.pop();
                String firstOperand = stack.pop();
                String newExp = '('+firstOperand+ch+secondOperand+')';
                stack.push(newExp);
            }
            ++i;
        }
        return stack.peek();
    }
}

// TC - O(N)
// SC - O(N)