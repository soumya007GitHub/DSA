class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); ++i){
            int j = 0;
            while(j < needle.length()){
                if(j < haystack.length() && haystack.charAt(i+j) == needle.charAt(j)){
                    ++j;
                if(j == needle.length()){
                    return i;
                }
                }
                else{
                    break;
                }
            }
        }
        return -1;
    }
}

// TC - O((m-n)*n)
// SC - O(1)