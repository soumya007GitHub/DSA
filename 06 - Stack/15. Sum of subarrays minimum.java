class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        // NSE Code
        for(int i = n-1; i>=0; --i){
            if(stack.isEmpty()){
                nse[i] = n;
            }
            else{
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nse[i] = n;
                }
                else{
                    nse[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        stack = new Stack<>();

        // PSE Code
        for(int i = 0; i<n; ++i){
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    pse[i] = -1;
                }
                else{
                    pse[i] = stack.peek();
                }
            }
            stack.push(i);
        }

// NSE - 1,4,4,4
// PSE - -1, -1, 1, 2

long sum = 0;
long MOD = 1_000_000_007;
// counting number of subarrays for each index
for(int i = 0; i<n; ++i){
    int left = i - pse[i];
    int right = nse[i] - i;
    sum = (sum + ((arr[i]*left)%MOD * right)%MOD )%MOD;
}
        return (int)(sum);
    }
}

// TC - O(N)
// SC - O(N)