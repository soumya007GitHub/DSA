public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode first = headA;
        ListNode second = headB;
        while(first != second){
            if(first == null || second == null){
                if(first == null){
                    first = headB;
                }
                else{
                    second = headA;
                }
            }
            else{
            first = first.next;
            second = second.next;
            }
        }
        return first;
    }
}

// TC - O(m+n)
// SC - O(1)