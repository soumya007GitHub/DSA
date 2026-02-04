class ArrayStack {

    private int array[] = new int[1000];
    private int topIndex;


    public ArrayStack() {
        topIndex = -1;
    }

    public void push(int x) {
       array[++topIndex] = x;
    }

    public int pop() {
        if(topIndex < 0){
            return -1;
        }
        int poppedEl = array[topIndex];
      array[topIndex] = -1;
      --topIndex;
      return poppedEl;
    }

    public int top() {
        if(topIndex < 0){
            return -1;
        }
        return array[topIndex];
    }

    public boolean isEmpty() {
        if(topIndex < 0){
            return true;
        }
        return false;
    }
}

// TC - O(1)
// SC - O(1000)