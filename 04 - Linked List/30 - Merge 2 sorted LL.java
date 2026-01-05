class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            if(list1 == null && list2 == null){
                return null;
            }
            else if(list1 == null){
                return list2;
            }
            else{
                return list1;
            }
        }
        ListNode A = list1;
        ListNode B = list2;
        ListNode dummy = new ListNode(-1);
        ListNode answer = dummy;
        while(A != null && B != null){
            if(A.val <= B.val){
                answer.next = A;
                A = A.next;
            }
            else{
                answer.next = B;
                B = B.next;
            }
            answer = answer.next;
        }
        if(A != null) answer.next = A;
        if(B != null) answer.next = B;
        return dummy.next;
    }
}

// TC - O(N)
// SC - O(1)