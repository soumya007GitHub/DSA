class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return next;
    }
}

// TC - O(N)
// SC - O(1)