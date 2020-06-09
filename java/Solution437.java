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
class Solution437 {
    
    private Map<Integer,Integer> visited;
    private int target;
    private int ans;
    
    /*
        T: O(N)
        S: O(N). O(N) for hashmap O(H) for stack.
    */
    public int pathSum(TreeNode root, int sum) {
        this.target=sum;
        this.visited=new HashMap<>();
        this.ans=0;
        visited.put(0,1);
        pathSumIterativePost(root,0);
        return ans;
    }
    
    private void pathSumIterativePost(TreeNode root, int sum){
        
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        
        sum=0;
        
        while(curr!=null||!stack.isEmpty()){
            
            if(curr!=null){
                sum+=curr.val;
                int complement=sum-target;

                ans+=visited.getOrDefault(complement,0);

                visited.put(sum,visited.getOrDefault(sum,0)+1);
                
                stack.push(curr);
                curr=curr.left;
            }else{
                
                TreeNode temp=stack.peek().right;
                
                if(temp==null){
                    temp=stack.pop();
                    
                    visited.put(sum,visited.get(sum)-1);
                    sum-=temp.val;
                    
                    while(!stack.isEmpty()&&stack.peek().right==temp){
                        temp=stack.pop();
                        visited.put(sum,visited.get(sum)-1);
                         sum-=temp.val;
                    }
                    
                }else{
                    curr=temp;
                }
            }
        }
        
    }
    
    private void pathSumStack(TreeNode root, int sum){
         if(root==null){
             ans=0;
             return;
         }
        
        sum=0;
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            
            if(!stack.isEmpty()&&stack.peek()==node){
                sum+=node.val;
                int complement=sum-target;

                ans+=visited.getOrDefault(complement,0);

                visited.put(sum,visited.getOrDefault(sum,0)+1);

                if(node.right!=null) {
                    stack.push(node.right);
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);  
                    stack.push(node.left);
                }                
            }else{
                visited.put(sum,visited.get(sum)-1);
                sum-=node.val;
            }
        }
    }
    

    private void pathSumRecursive(TreeNode root, int sum){
        if(root==null) return;
        
        sum+=root.val;
        int complement=sum-target;
        
        ans+=visited.getOrDefault(complement, 0);
        
        visited.put(sum,visited.getOrDefault(sum,0)+1);
        pathSumRecursive(root.left, sum);
        pathSumRecursive(root.right,sum);
        
        visited.put(sum,visited.get(sum)-1);
        
    } 
}