class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
       ListNode temp = head;
       while(temp != null){
        ListNode nextNode = temp.next;
        if(temp.val == target){
            if(temp == head){
                head = temp.next;
                if (head != null) {
                        head.prev = null;
                }
            }else{
                temp.prev.next = temp.next;
                if(temp.next != null){
                temp.next.prev = temp.prev;
                }
            }
        }
        temp = nextNode;
       }
       return head;
    }
}

// TC - O(N)
// SC - O(1)