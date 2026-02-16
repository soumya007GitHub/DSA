class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int total = nums.length;
        int[] answer = new int[total-k+1];
        int index = 0;
        for(int i = 0; i<total; ++i){
            if(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.removeFirst();
            }
            int current = nums[i];
            while(!dq.isEmpty() && current > nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1){
                answer[index++] = nums[dq.getFirst()];
            }
        }
        return answer;
    }
}

// while current > queue.top then queue.remove
// if before inserting queue is already full remove one element
// highest of sliding window will be queue.peek


// total i traversal = 1 based indexing 8 - 3 = 5