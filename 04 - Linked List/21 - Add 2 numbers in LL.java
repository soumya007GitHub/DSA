class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (list1 != null || list2 != null || carry != 0){
            int sum = carry;
            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }
            curr.next = new ListNode(sum%10, null);
            carry = sum/10;
            curr = curr.next;
        }
        return dummy.next;
    }
}


// TC - O(m+n)
// SC - O(1)