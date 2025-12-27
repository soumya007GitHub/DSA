class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode node= new ListNode(X, head);
        head = node;
        return head;
    }
}

// TC - O(1)
// SC - O(1)