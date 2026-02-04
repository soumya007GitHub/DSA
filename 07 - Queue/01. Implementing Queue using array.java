class ArrayQueue {
    private int[] array = new int[1000];
    private int firstIndex;
    private int lastIndex;
    public ArrayQueue() {
        firstIndex = -1;
        lastIndex = -1;
    }

    public void push(int x) {
        if(firstIndex == -1){
            ++firstIndex;
     } 
       array[++lastIndex] = x;
    }

    public int pop() {
      if(firstIndex == -1 || firstIndex > lastIndex){
        return -1;
      }
      int removedEl = array[firstIndex];
      array[firstIndex] = -1;
      ++firstIndex;
      return removedEl;
    }

    public int peek() {
        if(firstIndex == -1){
        return -1;
      }
      return array[firstIndex];
    }

    public boolean isEmpty() {
        if(firstIndex == -1 || firstIndex > lastIndex){
            return true;
        }
        if (firstIndex > lastIndex) {
            firstIndex = -1;
            lastIndex = -1;
         }
        return false;
    }
}

// TC - O(1)
// SC - O(N)