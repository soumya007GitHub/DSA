class Solution {
    public String postToPre(String postfix) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        while(i<postfix.length()){
            char ch = postfix.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                String newString = ""+ch;
                stack.push(newString);
            }else{
                String second = stack.pop();
                String first = stack.pop();
                stack.push(ch+first+second);
            }
            ++i;
        }
        return stack.peek();
    }
}

// TC - O(N)
// SC - O(N)