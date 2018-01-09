class MinStack {

    Stack<List> stack;
    int minValue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        List temp = new ArrayList<>();
        temp.add(x);
        if(minValue <= x) temp.add(minValue);
        else {
            temp.add(x);
            minValue = x;
        }
        stack.push(temp);
    }

    public void pop() {
        stack.pop();
        try {
            List temp = stack.peek();
            minValue = (int)temp.get(1);
        }
        catch(Exception ex) {
            minValue = Integer.MAX_VALUE;
        }
    }

    public int top() {
        List temp = stack.peek();
        return (int)temp.get(0);
    }

    public int getMin() {
        List temp = stack.peek();
        return (int)temp.get(1);
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
