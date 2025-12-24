class Solution {
    public String reverseWords(String s) {
        if(s.length() == 1){
            return s;
        }
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i) == ' ' && word.length() > 0){
                stack.push(word.toString());
                word = new StringBuilder();
            }else{
                if(s.charAt(i) != ' '){
            word.append(s.charAt(i));
                }
            }
        }
        if(word.length() > 0){
            stack.push(word.toString());
        }
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
            if(stack.size() > 0){
            answer.append(' ');
            }
        }
        return answer.toString();
    }
}

// TC - O(n)
// SC - O(1)