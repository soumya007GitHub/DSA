class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode rabbit = head;
        ListNode hare = head;
        while(hare != null && hare.next != null){
            rabbit = rabbit.next;
            hare = hare.next.next;
        }
        
        // FirstHalf Head
        ListNode firstHalfHead = head;
        // Reversing 2nd half and getting the second half head
        ListNode secondHalfHead = reverse(rabbit);
        while(secondHalfHead != null){
            if(firstHalfHead.val != secondHalfHead.val){
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode front = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return front;
    }
}


// TC - O(N)
// SC - O(1)