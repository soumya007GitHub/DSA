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
        temp = head;
        ListNode traverse = head;
        int count = 1;
        while(count != k){
            traverse = traverse.next;
            ++count;
        }
        ListNode next = traverse.next;
        traverse.next = null;
        ListNode rotated = rotate(head);
        if(temp == head){
            head = rotated;
        }
        temp.next = next;
        ListNode previous = temp;
        temp = temp.next;
        previous.next = reverseKGroup(temp, k);
        return head;
    }
    public ListNode rotate(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = rotate(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

// TC - O(N)
// SC - O(1)