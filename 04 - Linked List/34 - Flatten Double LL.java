class Solution {
    public Node tail = null;
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node temp = head;
        tail = head;
        while(temp != null){
        if(temp.child == null){
            tail = temp;
            temp = temp.next;
        }
        else{
            Node front = temp.next;
            temp.next = null;
           if (front != null) front.prev = null;
            Node branch = flatten(temp.child);
            temp.next = branch;
            branch.prev = temp;
            temp.child = null;
            if (front != null) {
            tail.next = front;
            front.prev = tail;
            }
            temp = front;
        }
        }
        return head;
    }
}

// TC - O(N) - All nodes in entire LL
// SC - O(D) - max depth of the LL