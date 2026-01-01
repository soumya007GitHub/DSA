class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
       ListNode zeroHead = null, zeroTail = null;
        ListNode oneHead = null, oneTail = null;
        ListNode twoHead = null, twoTail = null;
        ListNode temp = head;
       while(temp != null){
        if(temp.data == 0){
            if(zeroHead == null){
                zeroHead = temp;
                zeroTail = temp;
            }
            else{
                zeroTail.next = temp;
                zeroTail = temp;
            }
        }
        else if(temp.data == 1){
            if(oneHead == null){
                oneHead = temp;
                oneTail = temp;
            }
            else{
                oneTail.next = temp;
                oneTail = temp;
            }
        }
        else{
            if(twoHead == null){
                twoHead = temp;
                twoTail = temp;
            }
            else{
                twoTail.next = temp;
                twoTail = temp;
            }
        }
        temp = temp.next;
       }
       if (zeroTail != null) {
            zeroTail.next = (oneHead != null) ? oneHead : twoHead;
        }
        if (oneTail != null) {
            oneTail.next = (twoHead != null)? twoHead : null;
        }
        if (twoTail != null) {
            twoTail.next = null;
        }
        return (zeroHead != null) ? zeroHead : (oneHead != null) ? oneHead : twoHead;
    }
}

// TC - O(N)
// SC - O(1)