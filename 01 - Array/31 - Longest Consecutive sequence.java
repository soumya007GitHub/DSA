class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; ++i){
            set.add(nums[i]);
        }
        int index = 1;
        int maxCount = 0;
        for (int current : set) {
            if(!set.contains(current -1)){
            int count = 1;
            int next = current+1;
            while(set.contains(next)){
                ++count; 
                ++next;
            }
            maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
// TC - O(n)
// sc - o(n)