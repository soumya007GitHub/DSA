import java.util.*;
class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int max = 0;
        for(int i = 0; i<arr.length; ++i){
            prefixSum += arr[i];
            if (prefixSum == k) {
                max = Math.max(max, i + 1);
            }
            if(map.containsKey(prefixSum - k)){
                int length = i - map.get(prefixSum - k);
                max = Math.max(max, length);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return max;
    }
}

// Time Complexity - O(N), Space Complexity - O(N)