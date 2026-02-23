class Solution {
    public boolean checkIthBit(int n, int i) {
         return (n&(1<<i)) != 0;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)