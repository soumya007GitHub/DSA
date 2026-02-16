class StockSpanner {
    private ArrayList<Integer> array;
    private Stack<Integer> stack;
    public StockSpanner() {
        array = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && price >= array.get(stack.peek())){
            stack.pop();
        }
        array.add(price);
        if(stack.isEmpty()){
            stack.push(array.size()-1);
            return array.size();
        }
        int answer = array.size()-stack.peek()-1;
        stack.push(array.size()-1);
        return answer;
    }
}