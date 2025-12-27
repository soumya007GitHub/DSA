class Solution {
    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode newHead = new ListNode(data, null, head);
        head.prev = newHead;
        head = newHead;
        return head;
    }
}

// TC - O(1)
// SC - O(1)