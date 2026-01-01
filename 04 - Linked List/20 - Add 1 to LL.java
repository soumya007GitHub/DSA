class Solution {
    public ListNode addOne(ListNode head) {
        ListNode original = reverse(head);
        ListNode temp = original;
        int count = 0;
        while(temp != null){
            if(temp.val < 9){
                ++temp.val;
                return reverse(original);
            }
            temp.val = 0;
            temp = temp.next;
            ++count;
        }
        ListNode answer = new ListNode(1);
        ListNode temp2 = answer;
        while(count != 0){
            temp2.next = new ListNode(0);
            temp2 = temp2.next;
            --count;
        }
        return answer;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }
}

// TC - O(N)
// SC - O(1)