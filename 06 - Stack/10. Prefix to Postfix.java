class Solution {
    public String prefixToPostfix(String s) {
        int i = s.length()-1;
        Stack<String> stack = new Stack<>();
        while(i >= 0){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z')||(ch>='0' && ch<='9')){
                String newS = ""+ch;
                stack.push(newS);
            }
            else{
                String firstOperand = stack.pop();
                String secondOperand = stack.pop();
                stack.push(firstOperand+secondOperand+ch);
            }
            --i;
        }
        return stack.peek();
    }
}

// TC - O(N)
// SC - O(N)