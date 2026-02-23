class Solution {
    public int[] swap(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
        return new int[]{a, b};
    }
}
// Without XOR Operation
// TC - O(1)
// SC - O(1)


// With XOR Operation
class Solution {
    public int[] swap(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;
        return new int[]{a, b};
    }
}