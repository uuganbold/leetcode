import java.util.*;
class MyQueue232 {

    Stack<Integer> out;
    Stack<Integer> in;
    
    int firstElement;
    /** Initialize your data structure here. */
    public MyQueue232() {
        out=new Stack<>();
        in=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    /*
        T: O(1)
    */
    public void push(int x) {
        if(in.isEmpty()){
            firstElement=x;
        }
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    /*
        T: O(1)
    */
    public int pop() {
        if(out.isEmpty()){
            copyIntoOut();
        }
        return out.pop();
    }
    
    /** Get the front element. */
    /*
        T: O(1)
    */
    public int peek() {
        if(out.isEmpty()){
            return firstElement;
        }
        return out.peek();
    }
    
    private void copyIntoOut(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    
    
    /** Returns whether the queue is empty. */
    /*
        T: O(1)
    */
    public boolean empty() {
        return out.isEmpty()&&in.isEmpty();
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