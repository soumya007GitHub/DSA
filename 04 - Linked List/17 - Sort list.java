class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode previous = null;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);
        return mergeSort(leftHalf, rightHalf);
    }
    public ListNode mergeSort(ListNode leftHalf, ListNode rightHalf){
        ListNode l = leftHalf;
        ListNode r = rightHalf;
        ListNode result;
        ListNode head;
        if(l.val < r.val){
            result = l;
            head = l;
            l = l.next;
        }else{
            result = r;
            head = r;
            r = r.next;
        }
        while(l != null && r!= null){
            if(l.val < r.val){
                result.next = l;
                l = l.next;
            }else{
                result.next = r;
                r = r.next;
            }
            result = result.next;
        }
        result.next = (l != null) ? l : r;
        return head;
    }
}

// TC - O(NlogN)
// SC - O(1)