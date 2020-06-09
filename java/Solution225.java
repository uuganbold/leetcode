import java.util.*;
class Solution225 {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public Solution225() {
        queue=new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    /*
        T: O(N)
    */
    public void push(int x) {
        int size=queue.size();
        queue.offer(x);
        for(int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    /*
        T: O(1)
    */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    /*
        T: O(1)
    */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    /*
        T: O(1)
    */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */