import java.util.*;

class Solution589 {

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

    public List<Integer> preorder(Node root) {
        List<Integer> list=new LinkedList<>();
        preorderIterative(root,list);
        return list;
    }
    
    /**
     * T: O(N)
     * S: O(h)
     */
    private void preorderRecurse(Node root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        for(Node child:root.children){
              preorderRecurse(child,list);            
        }
    }
    
    /**
     * T: O(N)
     * S: O(N)
     */
    private void preorderIterative(Node root, List<Integer> list){
        if(root==null) return;
        
        Stack<Node> s=new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            Node node=s.pop();
            list.add(node.val);
            
            if(node.children==null) break;
            for(int i=node.children.size()-1; i>=0;i--){
                s.push(node.children.get(i));
            }
        }
    }
}