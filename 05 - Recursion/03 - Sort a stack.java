class Solution {
    public void sortStack(Stack<Integer> st) {
       if(st.isEmpty()){
        return;
       }
       int current = st.pop();
       sortStack(st);
       merge(st, current);
    }
    public void merge(Stack<Integer> st, int current){
        if(st.isEmpty() || st.peek() <= current){
            st.push(current);
            return;
        }
        int now = st.pop();
        merge(st, current);
        st.push(now);
    }
}

// TC - O(N^2)
// SC - O(N)