class Solution {
    public void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int current = st.pop();
        reverseStack(st);
        reverse(st, current);
    }
    public void reverse(Stack<Integer> st, int current){
        if(st.isEmpty()){
            st.push(current);
            return;
        }
        int now = st.pop();
        reverse(st, current);
        st.push(now);
    }
}

// TC - O(N^2)
// SC - O(N)