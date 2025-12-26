class Solution {
    public int countSubstr(String s, int k) {
        return answer(s, k) - answer(s, k-1);
    }
    public int answer(String s, int k){
        int left = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length(); ++right){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size() > k){
                char ch2 = s.charAt(left);
                map.put(ch2, map.getOrDefault(ch2, 0)-1);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                ++left;
            }
            count += (right-left)+1;
        }
        return count;
    }
}

// TC - O(N)
// SC - O(N)