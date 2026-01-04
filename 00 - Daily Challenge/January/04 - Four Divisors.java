class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; ++i) {
            int count = 0;
            for (int j = 1; j*j<= nums[i]; ++j) {
                if (nums[i] % j == 0) {
                    int other = nums[i] / j;

                    if (j == other) {
                        sum += j;
                        ++count;
                    } else {
                        sum += j + other;
                        count += 2;
                    }

                    if (count > 4) {
                        break;
                    }
                }
            }

            if (count == 4) {
                result += sum;
            }

            sum = 0;
        }

        return result;
    }
}

// TC - O(N*Math.sqrt(N))
// SC - O(1)