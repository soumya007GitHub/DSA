class Solution {
    public String largestOddNumber(String num) {
        if((num.charAt(num.length()-1)-'0')%2 != 0){
            return num;
        }
        int index = num.length()-1;
        while(index >= 0){
            if((num.charAt(index)-'0')%2 != 0){
                return num.substring(0, index+1);
            }
            --index;
        }
        return "";
    }
}

// TC - O(n)
// SC - O(1)