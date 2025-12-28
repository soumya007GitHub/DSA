class Solution {
    public ListNode reverseDLL(ListNode head) {
        ListNode current = head;
        ListNode newHead = head;
        while(current != null){
            ListNode back = current.prev;
            current.prev = current.next;
            current.next = back;
            newHead = current;
            current = current.prev;
        }
        head = newHead;
        return head;
    }
}

// TC - O(N)
// SC - O(1)