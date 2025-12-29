class Solution {
     public int findLengthOfLoop(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
            if(low == fast){
                return lengthOfCircularLoop(low);
            }
        }
        return 0;
     }
     public int lengthOfCircularLoop(ListNode low){
        int count = 1;
        ListNode temp = low;
        while(temp.next != low){
            ++count;
            temp = temp.next;
        }
        return count;
     }
 }

//  TC - O(N)
// SC - O(1)