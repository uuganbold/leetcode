import java.util.*;
class Solution606 {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    
         /*
            T: O(N)
            S: O(N)
         */
    public String tree2str(TreeNode t){
        if(t==null) return "";
        StringBuilder builder=new StringBuilder();
        
        Stack<TreeNode> stack=new Stack<>();
        Set<TreeNode> visited=new HashSet<>();
        stack.push(t);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(visited.contains(node)){
                stack.pop();
                builder.append(")");
            }else{
                visited.add(node);
                builder.append("(").append(node.val);
                if(node.left==null&&node.right!=null){
                    builder.append("()");
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        
        return builder.substring(1,builder.length()-1).toString();
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public String tree2strRecurse(TreeNode t) {
        if(t==null) return "";
        StringBuilder builder=new StringBuilder();
        builder.append(t.val);
        String left=tree2str(t.left);
        String right=tree2str(t.right);
        if(right.length()==0&&left.length()==0) return builder.toString();
        builder.append("(").append(left).append(")");
        if(right.length()!=0){
            builder.append("(").append(right).append(")");
        }
        
        return builder.toString();
    }
    
    
}