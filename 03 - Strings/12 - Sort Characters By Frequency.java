class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); ++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        StringBuilder answer = new StringBuilder();
        for(Map.Entry<Character, Integer> entry:list){
            char ch = entry.getKey();
            int frequency = entry.getValue();
            for(int i = 0; i<frequency; ++i){
                answer.append(ch);
            }
        }
        return answer.toString();
    }
}

// TC - O(nLOGn)
// SC - O(N)