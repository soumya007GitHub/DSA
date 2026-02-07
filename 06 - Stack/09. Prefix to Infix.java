class Solution {
    public String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        int i = s.length()-1;
        while(i >= 0){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                String newString = ""+ch;
                stack.push(newString);
            }else{
                String firstOperand = stack.pop();
                String secondOperand = stack.pop();
                stack.push("(" + firstOperand + ch + secondOperand + ")");
            }
            --i;
        }
        return stack.peek();
    }
}

// TC - O (N)
// SC - O (N)