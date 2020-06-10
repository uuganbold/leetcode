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
class Solution671 {

    /*
        T: O(N)
        S: O(N)
    */
    public int findSecondMinimumValue(TreeNode root) {
        return bfs(root);
    }
    
    private int bfs(TreeNode root){
        if(root==null){
            return -1;
        }
        
        int min=root.val;
        int exception=root.val;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            root=queue.poll();
            
            if(root.val!=exception&&(min==exception||root.val<min)){
                min=root.val;
            }
            
            if(root.val==exception&&root.left!=null&&root.right!=null){
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        
        if(min==exception){
            return -1;
        }
        
        return min;
        
    }
    
    private int dfs(TreeNode root){
        if(root==null){
            return -1;
        }
        int min=root.val;
        int exception=root.val;
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            root=stack.pop();
            
            if(min==exception||root.val!=exception&&root.val<min){
                min=root.val;
            }
            
            if(root.val==exception&&root.left!=null&&root.right!=null){
                stack.push(root.right);
                stack.push(root.left);
            }
        }
        
        if(min==exception){
            return -1;
        }
        return min;
    }
    
    public int findDifferentMinimumValue(TreeNode root, int val){
        if(root==null){
            return val;
        }
        if(root.val!=val){
            return root.val;
        }
        
        int left=findDifferentMinimumValue(root.left,val);
        int right=findDifferentMinimumValue(root.right,val);
        
        if(left==val){
            return right;
        }else if(right==val){
            return left;
        }else{
            return Math.min(left,right);
        }
    }
    
    
}