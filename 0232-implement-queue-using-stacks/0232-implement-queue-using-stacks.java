class MyQueue {
    Stack<Integer> st;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        this.st.insertElementAt(x,0);
    }
    
    public int pop() {
        return this.st.pop();
    }
    
    public int peek() {
        return this.st.peek();
    }
    
    public boolean empty() {
        return this.st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */