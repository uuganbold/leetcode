/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution572 {

    /*
        T: O(S*T)
        S: S(S+T)
    */
    public boolean isSubtreeRecursive(TreeNode s, TreeNode t) {
        if(t==null){
            return true;
        }
        if(s==null){
            return false;
        }
        return identical(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);  
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t){
        if(t==null){
            return true;
        }
        if(s==null){
            return false;
        }
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(s);
        
        while(!stack.isEmpty()){
            s=stack.pop();
            
            if(s.val==t.val&&identicalIterative(s,t)){
                return true;
            }
            
            if(s.right!=null){
                stack.push(s.right);
            }
            if(s.left!=null){
                stack.push(s.left);
            }
        }
        
        return false;
    }
    
    private boolean identicalIterative(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(s);
        stack.push(t);
        
        while(!stack.isEmpty()){
            t=stack.pop();
            s=stack.pop();
            
            if(s==null&&t==null){
                continue;
            }
            
            if(s==null||t==null){
                return false;
            }
            
            if(s.val!=t.val){
                return false;
            }
            stack.push(s.right);
            stack.push(t.right);

            stack.push(s.left);
            stack.push(t.left);
            
        }
        
        return true;
    }
    
    /*
        T: O(min(S,T))
        S: O(min(S,T))
    */
    private boolean identical(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        
        return s.val==t.val&&
            identical(s.left,t.left)&&
            identical(s.right,t.right);
    }
}