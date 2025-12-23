class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String word = strs[0];
        for(int i = 0; i<word.length(); ++i){
            char ch = word.charAt(i);
            for(int j = 1; j<strs.length; ++j){
                if(i >= strs[j].length()){
                    return word.substring(0, i);
                }
                if(strs[j].charAt(i) != ch){
                    return word.substring(0, i);
                }
            }
        }
        return word;
    }
}

// TC - O(N * M)
// SC - O(1)