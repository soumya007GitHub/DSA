class Solution {
    public ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.next.val == temp.val){
                ListNode duplicate = temp.next;   // store duplicate
                temp.next = duplicate.next;       // remove it

                if (duplicate.next != null) {
                    duplicate.next.prev = temp;   // fix prev
                }
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}

// TC - O(n)
// SC - O(1)