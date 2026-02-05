class MinStack {
    class Node{
        int data;
        int min;
        Node(int data, int min){
            this.data = data;
            this.min = min;
        }
    }
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(!stack.isEmpty()){
            stack.push(new Node(val, Math.min(val, stack.peek().min)));
        }else{
        stack.push(new Node(val, val));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().data;
    }
    
    public int getMin() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().min;
    }
}

// TC - O(1)
//  SC - O(N)