class Solution {
    public String infixToPrefix(String s) {
        StringBuilder reversedString = new StringBuilder();
        for(int i = s.length()-1; i>=0; --i){
            char ch = s.charAt(i);
            if (ch == '(') reversedString.append(')');
            else if (ch == ')') reversedString.append('(');
            else reversedString.append(ch);
        }
        String newS = reversedString.toString();
        int i = 0;
        reversedString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(i < newS.length()){
            char ch = newS.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                reversedString.append(ch);
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    reversedString.append(stack.pop());
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                if(!stack.isEmpty() && priorityCheck(stack.peek()) < priorityCheck(ch)){
                    stack.push(ch);
                }
                else{
                    while (!stack.isEmpty() &&
                      (priorityCheck(stack.peek()) > priorityCheck(ch) ||
                      (priorityCheck(stack.peek()) == priorityCheck(ch) && ch != '^'))) {
                    reversedString.append(stack.pop());
                }
                    stack.push(ch);
                }
            }
            ++i;
        }
        while(!stack.isEmpty()){
            reversedString.append(stack.pop());
        }
         return reversedString.reverse().toString();
    }
    public int priorityCheck(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else{
            return -1;
        }
    }
}

// TC - O(N)
// SC - O(N)