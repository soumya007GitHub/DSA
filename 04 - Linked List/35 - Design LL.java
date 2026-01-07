class MyLinkedList {
    
    // Node
    class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int size = 0;
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    // 1
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node temp = head.next;
        for(int i = 0; i<index; ++i){
            temp = temp.next;
        }
        return temp.value;
    }
    
    public void addAtHead(int val) {
         Node newNode = new Node(val);
         newNode.next = head.next;
         head.next.prev = newNode;
         head.next = newNode;
         newNode.prev = head;
         ++size;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node last = tail.prev;

        last.next = newNode;
        newNode.prev = last;
        newNode.next = tail;
        tail.prev = newNode;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node nextNode = temp.next;
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        ++size;
    }


    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node temp = head.next;
        for(int i = 0; i<index; ++i){
            temp = temp.next;
        }
        Node previous = temp.prev;
        previous.next = temp.next;
        temp.next.prev = previous;
        --size;
    }
}


// TC - O(N)
// SC - O(1)