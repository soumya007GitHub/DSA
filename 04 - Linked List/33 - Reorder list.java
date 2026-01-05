class Solution {
    public void reorderList(ListNode head) {
    ListNode mid = getMid(head);
    ListNode second = reverse(mid.next);
    mid.next = null;
     ListNode first = head;
     while(second != null){
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;
        first.next = second;
        second.next = temp1;
        first = temp1;
        second = temp2;
     }
    return;
    }
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

// TC - O(N)
// SC - O(N)