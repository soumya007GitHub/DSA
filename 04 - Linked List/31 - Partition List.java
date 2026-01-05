class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyLeft = new ListNode(-1);
        ListNode leftTail = dummyLeft;
        ListNode dummyRight = new ListNode(-1);
        ListNode rightTail = dummyRight;
        
        ListNode temp = head;
        ListNode next = head;
        while(temp != null){
            next = temp.next;
            temp.next = null;
            if(temp.val < x){
                leftTail.next = temp;
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = temp;
                rightTail = rightTail.next;
            }
            temp = next;
        }
        leftTail.next = dummyRight.next;
        return dummyLeft.next;
    }
}
// TC - O(N)
// SC - O(1)