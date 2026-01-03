class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            ++size;
            temp = temp.next;
        }
        if(size < k){
            return head;
        }
        ListNode newHead = head;
        temp = head;
        int count = 1;
        while(count < k){
            temp = temp.next;
            ++count;
        }
        ListNode next = temp.next;
        temp.next = null;
        ListNode reversedHead = reverse(newHead);
        newHead.next = next;
        newHead.next = reverseKGroup(next, k);
        return reversedHead;
    }
    public ListNode reverse(ListNode head){
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
// SC - O(1)