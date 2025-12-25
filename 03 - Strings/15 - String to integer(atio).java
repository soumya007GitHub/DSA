class Solution {
    public int myAtoi(String s) {
        long answer = 0;
        boolean sign = false;
        boolean started = false;
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int number = ch-'0';
                answer = answer * 10 + number;
                if (answer > Integer.MAX_VALUE) {
                    break;
                }
                started = true;
            }
            else if((ch == '-' || ch == '+') && !started){
                sign = (ch == '-') ? true : false;
                started = true;
            }
            else if(ch == ' ' && !started){
                continue;
            }
            else{
                break;
            }
        }
        
        if(sign){
            answer = -answer;
        }
        if (answer > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (answer < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)answer;
    }
}

// TC - O(N)
// SC - O(1)