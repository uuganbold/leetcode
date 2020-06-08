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
class Solution101 {
    /*
        T: O(N)
        S: O(N)
    */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetricBFS(root.left, root.right);
    }
    
    private boolean isSymmetricBFS(TreeNode left,TreeNode right){
        Queue<TreeNode> leftQueue=new LinkedList<>();
        Queue<TreeNode> rightQueue=new LinkedList<>();
        
        leftQueue.offer(left);
        rightQueue.offer(right);
        
        
        while(!leftQueue.isEmpty()&&!rightQueue.isEmpty()){
            left=leftQueue.poll();
            right=rightQueue.poll();
            
            if(left==null&&right==null){
                continue;
            }
            
            if(left==null||right==null){
                return false;
            }
            
            if(left.val!=right.val){
                return false;
            }
            
            leftQueue.offer(left.left);
            leftQueue.offer(left.right);
            
            rightQueue.offer(right.right);
            rightQueue.offer(right.left);
        }
        
        while(!leftQueue.isEmpty()||!rightQueue.isEmpty()){
            return false;
        }
        
        return true;
        
    }
    
    private boolean isSymmetricDFS(TreeNode left, TreeNode right){
        
        Stack<TreeNode> leftStack=new Stack<>();
        Stack<TreeNode> rightStack=new Stack<>();
        
        leftStack.push(left);
        rightStack.push(right);
        
        while(!leftStack.isEmpty()){
            left=leftStack.pop();
            right=rightStack.pop();
            
            if(left==null&&right==null){
                continue;
            }
            if(left==null||right==null){
                return false;
            }
            
            if(left.val!=right.val){
                return false;
            }
            
            leftStack.push(left.left);
            leftStack.push(left.right);
            
            rightStack.push(right.right);
            rightStack.push(right.left);
        }
        
        if(!rightStack.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return left.val==right.val&&
            isSymmetric(left.left,right.right)&&
            isSymmetric(left.right,right.left);
    }
}