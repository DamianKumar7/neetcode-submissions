class MinStack {
    Stack<Integer>stk;
    Stack<Integer>minStack;
    public MinStack() {
        stk = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(!minStack.isEmpty()){
            if(val<=minStack.peek()){
                minStack.push(val);
            }
        }else if(minStack.isEmpty()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(val == minStack.peek()){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
