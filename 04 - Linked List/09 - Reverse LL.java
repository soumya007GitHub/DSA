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
// Recursion Method

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode front = current.next;
            current.next = previous;
            previous = current;
            current = front;
        }
        return previous;
    }
}
// Iterative Method

// TC - O(N)
// SC - O(1)