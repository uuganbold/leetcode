import java.util.List;
class Solution559 {

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

    /*
        T: O(n)
        S: O(h)
    */
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max=0;
        if(root.children!=null){
           for(Node child: root.children){
                int depth=maxDepth(child);
               if(depth>max) max=depth;
           } 
        }
        return max+1;
        
    }
}