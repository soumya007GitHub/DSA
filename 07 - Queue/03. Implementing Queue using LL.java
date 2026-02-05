class LinkedListQueue {
    class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    ListNode head;
    ListNode tail;
    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public void push(int x) {
       ListNode newNode = new ListNode(x);
       if(head == null){
        head = newNode;
       tail = newNode;
       }
       else{
        tail.next = newNode;
        tail = tail.next;
       }
    }

    public int pop() {
        if(head != null){
            ListNode front = head;
            head = head.next;
            front.next = null;
            if (head == null) {
                tail = null;
            }
            return front.data;
        }
        return -1;
    }

    public int peek() {
        if(head != null){
            return head.data;
        }
        return -1;
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }
}


// TC - o(1) for all operations
// sc - o(n) for queue of size n, as we are using linked list to implement queue.