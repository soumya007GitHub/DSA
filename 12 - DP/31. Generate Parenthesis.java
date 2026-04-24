class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        helper(sb, 1, 0, n, ans);
        return ans;
    }
    public void helper(StringBuilder sb, int l, int r, int n, List<String> ans){
        if(l == n && r == n){
            ans.add(sb.toString());
            return;
        }
        if(l < n){
            sb.append("(");
            helper(sb, l+1, r, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r < n && l > r){
            sb.append(")");
            helper(sb, l, r+1, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}