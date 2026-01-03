class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp.next != null){
            ++size;
            temp = temp.next;
        }
        if(k % (size+1) == 0){
            return head;
        }
        k = k%(size+1);
        temp.next = head;
        size = size+1-k;
        int count = 0;
        while(count != size){
            temp = temp.next;
            ++count;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}

// TC - O(n)
// SC - O(1)