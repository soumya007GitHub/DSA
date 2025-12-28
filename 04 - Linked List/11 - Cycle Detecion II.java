
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode rabbit = head;
        ListNode hare = head;
        while(hare != null && hare.next != null){
            rabbit = rabbit.next;
            hare = hare.next.next;
            if(rabbit == hare){
                if(rabbit == head){
                    return rabbit;
                }else{ 
                    rabbit = head;
                    while(rabbit != hare){
                        rabbit = rabbit.next;
                        hare = hare.next;
                    }
                    return rabbit;
                }
            }
        }
        return null;
    }
}

// TC - O(N)
// SC - O(1)