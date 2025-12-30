class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while(fast != null && fast.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = slow.next;
        return head;
    }
}

// TC - O(N)
// SC - O(1)