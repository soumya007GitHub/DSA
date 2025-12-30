class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            ++size;
            temp = temp.next;
        }
        if(size < n){
            return null;
        }
        if (n == size) {
            return head.next;
        }
        temp = head;
        for (int i = 1; i < size - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

// TC - O(n)
// SC - O(1)