class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        for(int i = 0; i<s.length(); ++i){
            array[i] = s.charAt(i);
        }
        int low = 0;
        for(int i = 0; i<array.length; ++i){
            if(array[i] == ' ' || i == array.length-1){
                int high = i-1;
                if(i == array.length -1){
                    high = i;
                }
                while(low < high){
                    char ch = array[low];
                    array[low] = array[high];
                    array[high] = ch;
                    ++low;
                    --high;
                }
                low = i+1;
            }
        }
       return new String(array);
    }
}

// TC - O(n)
// SC - O(1) - here char array is unavoidable and this is output space and for any solution for this same problem the extra space to get answer is unavoidable so we will not count stringBuilder space or arraySpace in space complexity.