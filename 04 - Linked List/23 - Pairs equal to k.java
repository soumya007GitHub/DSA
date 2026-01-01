class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if (head == null) return answer;

        // Find tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Two pointers
        while (head != tail && head.prev != tail) {
            int sum = head.val + tail.val;

            if (sum == target) {
                answer.add(List.of(head.val, tail.val));
                head = head.next;
                tail = tail.prev;
            } 
            else if (sum < target) {
                head = head.next;
            } 
            else {
                tail = tail.prev;
            }
        }

        return answer;
    }
}

// TC - O(N)
// SC - O(1)