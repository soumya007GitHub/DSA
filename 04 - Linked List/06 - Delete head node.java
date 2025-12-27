class Solution {
    public ListNode deleteHead(ListNode head) {
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        return head;
    }
}


// TC - O(1)
// SC - O(1)