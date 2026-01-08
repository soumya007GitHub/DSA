class Solution {
    public int myAtoi(String s) {
        long answer = 0;
        boolean sign = false;
        boolean isdigitstarted = false;
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == ' '){
                if (isdigitstarted || sign) break;
                continue;
            }
            else if(ch == '-' || ch == '+'){
                if (isdigitstarted || sign) break;
                sign = true;
                sign = (ch == '-') ? true : false;
                isdigitstarted = true;
            }
            else if(Character.isDigit(ch)){
                answer = answer*10+(ch-'0');
                if(!sign && answer > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(sign && -answer < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                isdigitstarted = true;
            }
            else{
                break;
            }
        }
        if(sign){
            answer = -(answer);
        }
        return (int)answer;
    }
}

// TC - O(N)
// SC - O(1)