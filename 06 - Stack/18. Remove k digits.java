class Solution {
    public String removeKdigits(String num, int k) {
        int count = k;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num.length(); ++i){
            if(count == 0 || stack.isEmpty()){
                stack.push(num.charAt(i) - '0');
                continue;
            }
            else{
                if(stack.peek() <= num.charAt(i) - '0'){
                    stack.push(num.charAt(i) - '0');
                }
                else{
                    while(!stack.isEmpty() && stack.peek() > num.charAt(i) - '0' && count > 0){
                        count--;
                        stack.pop();
                    }
                    stack.push(num.charAt(i) - '0');
                }
            }
        }

        while(count > 0 && !stack.isEmpty()){
            stack.pop();
            count--;
        }

        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        answer.reverse();
        // 🔥 remove leading zeros
        int index = 0;
        while(index < answer.length() && answer.charAt(index) == '0'){
            index++;
        }

        if(index == answer.length()) return "0";

        return answer.substring(index);
    }
}

// TC - O(n) where n is the length of the string num
// SC - O(n) where n is the length of the string num