class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node dummy = new Node(-1);
        Node tail = dummy;
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            map.put(temp, copy);

            tail.next = copy;
            tail = tail.next;

            temp = temp.next;
        }

        temp = head;
        Node curr = dummy.next;

        while (temp != null) {
            curr.random = map.get(temp.random);
            temp = temp.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}

// TC - O(N)
// SC - O(N)