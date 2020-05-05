

import java.util.*;

class Solution590 {

    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result=new LinkedList<>();
        postorderOneStack(root,result);
        return result;
    }
    /**
     * T: O(N)
     * S: O(h)
     */
    private void postorderRecurse(Node root, LinkedList<Integer> list){
        if(root==null) return;
        for(Node child:root.children){
            postorderRecurse(child,list);
        }
        list.add(root.val);
    }
    /**
     * T: O(N)
     * S: O(N)
     */
    private void postorderTwoStacks(Node root, LinkedList<Integer> list){
        if(root==null) return;
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node=stack1.pop();
            stack2.push(node);
            if(node.children==null) continue;
            for(Node child:node.children){
                stack1.push(child);
            }         
        }
        
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
    } 
    
    /**
     * T: O(N)
     * S: O(h)
     */
    private void postorderOneStack(Node root, List<Integer> list){
        if(root==null) return;
        Stack<Node> stack=new Stack<>();
        
        stack.push(root);
        
        while(!stack.empty()){
            Node node=stack.peek();
            if(node!=null){
                while(node.children!=null&&node.children.size()>0){
                    stack.push(null);
                    for(int c=node.children.size()-1;c>=0;c--){
                        stack.push(node.children.get(c));
                    } 
                    Node firstChild=node.children.get(0);
                    node=firstChild;
                }
            }else{
                stack.pop();
            }
            list.add(stack.pop().val);
        }
        
    }
}