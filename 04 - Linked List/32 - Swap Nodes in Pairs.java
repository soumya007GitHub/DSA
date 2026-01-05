class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode front = swapPairs(curr.next);
        curr.next = prev;
        prev.next = front;
        return curr;
    }
}
// TC - O(N)
// SC - O(1)