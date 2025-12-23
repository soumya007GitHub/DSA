class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] array = new int[26];
        for(int i = 0; i<s.length(); ++i){
            int ch1 = s.charAt(i)-'a';
            int ch2 = t.charAt(i)-'a';
            array[ch1]++;
            array[ch2]--;
        }
        for(int i = 0; i<26; ++i){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }
}

// TC - O(n)
// SC - O(total number of alphabets)