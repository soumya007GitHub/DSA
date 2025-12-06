import java.util.* ;
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		int max = 0;
		int left = 0;
		int right = 0;
		int sum = 0;
		// 10, 5, 2, 7, 1, 9
		while(right < nums.length){
			sum += nums[right];
			while(sum > k){
				sum -= nums[left];
				++left;
			}
			if(sum == k){
				max = Math.max(max, right-left+1);
			}
			++right;
		}
		return max;
	}
}

// Time Complexity - O(n) Space Complexity - O(1)