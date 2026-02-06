class Solution {
    public String infixToPostfix(String s) {
       int i = 0;
       Stack<Character> stack = new Stack<>();
       StringBuilder answer = new StringBuilder();
       while(i < s.length()){
        char ch = s.charAt(i);
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
            answer.append(ch);
        }
        else if(ch == '('){
            stack.push(ch);
        }
        else if(ch == ')'){
            while(!stack.isEmpty() && stack.peek() != '('){
                answer.append(stack.pop());
            }
            if(!stack.isEmpty()){
            stack.pop();
            }
        }
        else{
            if(!stack.isEmpty() && priorityChecker(ch) > priorityChecker(stack.peek())){
                stack.push(ch);
            }
            else{
                while(!stack.isEmpty() && (priorityChecker(stack.peek()) > priorityChecker(ch) || (priorityChecker(stack.peek()) == priorityChecker(ch) && ch != '^'))){
                    answer.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        ++i;
       }
       while(!stack.isEmpty()){
        answer.append(stack.pop());
       }
       return answer.toString();
    }
    public int priorityChecker(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return -1;
        }
    }
}

// TC - o(N) - FOR traversing the string and o(N) for popping the stack
// SC - o(N) - for the stack and o(N) for the answer string builder