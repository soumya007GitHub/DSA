
class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = flattenLinkedList(head.next);
        return merger(head, head.next);
    }
    public ListNode merger(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.child = a;
                a = a.child;
            } else {
                tail.child = b;
                b = b.child;
            }
            tail = tail.child;
        }
        tail.child = (a != null) ? a : b;

        return dummy.child;
    }
}

// TC - O(M*N)
// SC - O(N)