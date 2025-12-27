class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode low = head;
        ListNode high = head;
        while(high != null){
            if(high.next != null){
            low = low.next;
            high = high.next.next;
            }else{
                break;
            }
        }
        return low;
    }
}

// TC - O(n)
// SC - O(1)