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
class Solution111 {
    
    /*
        T: O(2^depth)
        S: O(2^depth)
    */
    public int minDepth(TreeNode root) {
        return dfsStack(root);
    }
    
    private int dfsStack(TreeNode root){
        if(root==null){
            return 0;
        }
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        stack.push(root);
        int min=Integer.MAX_VALUE;
        int depth=0;
        
        while(!stack.isEmpty()){
            
            TreeNode node=stack.pop();
            
            if(!stack.isEmpty()&&node==stack.peek()){
                depth++;
                
                if(depth>=min){
                    continue;
                }
                
                if(node.left==null&&node.right==null){
                    min=depth;
                    continue;
                }
                
                if(node.left!=null){
                    stack.push(node.left);
                    stack.push(node.left);
                }
                
                if(node.right!=null){
                    stack.push(node.right);
                    stack.push(node.right);
                }
                
            }else{
                depth--;
            }
            
            
        }
        
        return min;
        
    }
    
    private int dfsRecurse(TreeNode root, int depth, int min){
        if(root==null){
            return min;
        }
        
        depth++;
        if(depth>=min){
            return min;
        }
        
        if(root.left==null&&root.right==null){
             return depth;
        }
        
        min=dfsRecurse(root.left,depth,min);
        min=dfsRecurse(root.right,depth,min);
        
        return min;
    }
    
    private int bfs(TreeNode root){
        if(root==null){
            return 0;
        }
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        
        while(!queue.isEmpty()){
            
            depth++;
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                
                if(node.left==null&&node.right==null){
                     return depth;
                }
                
                if(node.left!=null){
                    temp.offer(node.left);
                }
                
                if(node.right!=null){
                    temp.offer(node.right);
                }
            }
            
            queue=temp;
            
        }
        
        throw null;
    }
    

}