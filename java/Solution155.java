import java.util.EmptyStackException;
public class Solution155{

    class MinStack {

        private class Node{
            int val;
            int min;
            Node below;
            
            public Node(int val, Node below){
                this.val=val;
                this.below=below;
                if(below==null){
                    this.min=val;
                }else{
                    this.min=Math.min(val,below.min);
                }   
            }
        }
        
        private Node top;
        /** initialize your data structure here. */
        public MinStack() {
            
        }
        
        public void push(int x) {
            top=new Node(x,this.top);
        }
        
        public void pop() {
            if(top==null){
                throw new EmptyStackException();
            }
            top=top.below;
        }
        
        public int top() {
            if(this.top==null){
                throw new EmptyStackException();
            }
            return top.val;
        }
        
        public int getMin() {
            if(this.top==null){
                throw new EmptyStackException();
            }
            return top.min;
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
}