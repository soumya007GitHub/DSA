class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        for(int i = s.length()-1; i>=0; --i){
            char ch = s.charAt(i);
            int valueInt = value(ch);
            if(i == s.length()-1){
                answer += valueInt;
            }else{
                int previousValue = value(s.charAt(i+1));
                if(previousValue > valueInt){
                    answer -= valueInt;
                }else{
                    answer += valueInt;
                }
            }
        }
        return answer;
    }
    public int value(char ch){
        switch(ch){
            case 'I' : {
                return 1;
            }
            case 'V' : {
                return 5;
            }
            case 'X' : {
                return 10;
            }
            case 'L' : {
                return 50;
            }
            case 'C' : {
                return 100;
            }
            case 'D' : {
                return 500;
            }
            default : {
                return 1000;
            }
        }
    }
}

// TC - O(N)
// SC - O(1)