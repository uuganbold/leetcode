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
class Solution112 {
    
    /*
        T: O(N)
        S: O(H)
    */
    public boolean hasPathSum(TreeNode root, int sum) {
         return dfsStackPostOrder(root,sum);
    }
    
    private boolean dfsStackPostOrder(TreeNode root, int target){
        if(root==null){
            return false;
        }
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode curr=root;
        int sum=0;
        
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                sum+=curr.val;
                stack.push(curr);
                curr=curr.left;
            }else{
                curr=stack.peek().right;
                if(curr==null){
                    
                    curr=stack.pop();
                    if(curr.left==null&&sum==target){
                        return true;
                    }
                    sum-=curr.val;
                    
                    while(!stack.isEmpty()&&curr==stack.peek().right){
                        curr=stack.pop();
                        sum-=curr.val;
                    }
                    
                    curr=null; 
                }
            }
            
        }
        
        return false;
        
    }
    
    private boolean dfsStackPostOrderDuplicatePush(TreeNode root, int target){
        if(root==null){
            return false;
        }
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        stack.push(root);
        
        int sum=0;
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            
            if(!stack.isEmpty()&&node==stack.peek()){
                sum+=node.val;
                
                if(node.right==null&&node.left==null){
                    if(sum==target){
                        return true;
                    }
                }
                
                if(node.right!=null){
                    stack.push(node.right);
                    stack.push(node.right);
                }
                
                if(node.left!=null){
                    stack.push(node.left);
                    stack.push(node.left);
                }
                
            }else{
                sum-=node.val;
            }
            
        }
        
        return false;
    }
    
    private boolean dfs(TreeNode root, int target, int currentSum){
        if(root==null){
            return false;
        }
        
        currentSum=currentSum+root.val;
        
        if(root.right==null&&root.left==null){
              if(target==currentSum){
                  return true;
              }else{
                  return false;
              }
        }
        
        boolean ans=dfs(root.left,target,currentSum);
        if(!ans){
            ans=dfs(root.right,target,currentSum);
        }
        
        return ans;
    }
}