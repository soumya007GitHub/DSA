class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int data){
            this.key = key;
            this.value = data;
            prev = null;
            next = null;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(0, 0);  // dummy head
        tail = new Node(0, 0);  // dummy tail

        head.next = tail;
        tail.prev = head;
       map = new HashMap<>();
       this.capacity = capacity;
    }

    public int get(int key) {
       if(!map.containsKey(key)){
        return -1;
       }
       Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {

            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtFront(newNode);
        }
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

}

// TC - O(1) for both get and put operations
// SC - O(capacity)