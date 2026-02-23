class Solution {
    public int countSetBits(int n) {
        int count = 0;
        while(n >= 1){
            if(n%2 == 1){
                ++count;
            }
            n /= 2;
        }
        return count;
    }
}


// TC - O(logN)
// SC - O(1)