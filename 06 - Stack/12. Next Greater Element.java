class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1; i>=0; --i){
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
                stack.push(nums2[i]);
            }
            else if(!stack.isEmpty()){
                if(stack.peek() > nums2[i]){
                    map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }else{
                    while(!stack.isEmpty() && stack.peek() < nums2[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        map.put(nums2[i], -1);
                    }
                    else{
                        map.put(nums2[i], stack.peek());
                    }
                    stack.push(nums2[i]);
                }
            }
        }
        for(int i = 0; i<nums1.length; ++i){
            answer[i] = map.get(nums1[i]);
        }
        return answer;
    }
}

// TC - O(N) + O(M) where N is the length of nums2 and M is the length of nums1
// SC - O(N) where N is the length of nums2
