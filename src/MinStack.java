class MinStack {

    TreeMap<Integer, Integer> map;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        map = new TreeMap<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(map.containsKey(x)) map.put(x, map.get(x)+1);
        else map.put(x, 1);
    }

    public void pop() {
        int tempnum = stack.pop();
        int count = map.get(tempnum);
        if(count == 1) map.remove(tempnum);
        else map.put(tempnum, count-1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            return entry.getKey();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
