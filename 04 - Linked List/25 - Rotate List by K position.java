class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            ++size;
            temp = temp.next;
        }
        k = k%size;
        if(k == 0){
            return head;
        }
        head = rotate(head);
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;

        while (count < k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        ListNode secondHead = rotate(curr); 
        head.next = secondHead;
        return prev;
    }
    public ListNode rotate(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = rotate(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }
}

// TC - O(n)
// SC - O(1)