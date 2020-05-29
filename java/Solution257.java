import java.util.*;
class Solution257 {

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
            S: O(H)
         */
    public List<String> binaryTreePaths(TreeNode root) {
        List<TreeNode> path=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        
        dfsStack(root,ans);
        
        return ans;
    }
    
    private void dfsStack(TreeNode root, List<String> ans){
        if(root==null) return;
        
        Stack<TreeNode> stack=new Stack<>();
        Deque<TreeNode> path=new LinkedList<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node!=path.peekLast()){
                path.add(node);
                stack.push(node);
            }else{
                path.removeLast(); 
                continue;
            }
            
            if(node.left==null&&node.right==null){
                ans.add(convertPathToString(path));
            }
            
            if(node.right!=null){
                stack.push(node.right);
            }
            
            if(node.left!=null){
                stack.push(node.left);
            }
            
        }
        
    }
    
    private void dfsRecurse(TreeNode root, List<TreeNode> path, List<String> ans){
          if(root==null) return;
          path.add(root);
          if(root.left==null&&root.right==null){
              ans.add(convertPathToString(path));
          }else{
              dfsRecurse(root.left,path,ans);
              dfsRecurse(root.right,path,ans);              
          }
          path.remove(root);
    }
    
    
    private String convertPathToString(Iterable<TreeNode> path){
          StringBuilder builder=new StringBuilder();
          String prefix="";
          for(TreeNode node:path){
              builder.append(prefix);
              prefix="->";
              builder.append(node.val);
          }
        
        return builder.toString();
    }
    
}