class LinkedListStack {
    class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    ListNode head;
    public LinkedListStack() {
        head = null;
    }

    public void push(int x) {
       ListNode current = new ListNode(x);
       current.next = head;
       head = current;
    }

    public int pop() {
      ListNode poppedNode = head;
      head = head.next;
      return poppedNode.data;
    }

    public int top() {
        return head.data;
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }
}


// TC - O(1)
// SC - O(N)