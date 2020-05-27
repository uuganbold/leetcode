import java.util.*;
class Solution783 {

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

    Integer prev=null;
    int minDiff=Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        inorderMorris(root);
        return minDiff;
    }
    
    private void traverse(TreeNode node){
        if(prev!=null){
            int diff=node.val-prev;
            if(diff<minDiff) minDiff=diff;
        }
        prev=node.val;
    }
    
    /*
        T: O(N)
        S: O(1)
    */
    private void inorderMorris(TreeNode root){
        TreeNode node=root;
        TreeNode cur;
        
        while(node!=null){
            
            if(node.left!=null){
                
                cur=node.left;
                while(cur.right!=null&&cur.right!=node){
                    cur=cur.right;
                }
                
                if(cur.right==node){
                    traverse(node);
                    cur.right=null;
                    node=node.right;
                }else{
                    cur.right=node;
                    node=node.left;
                }
                
                
            }else{
                traverse(node);
                node=node.right;
            }
            
        }
        
    }
    
    /*
        T: O(N)
        S: O(H)
    */
    private void inorderStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            
            cur=stack.pop();
            traverse(cur);
            
            cur=cur.right;   
        }
    }
    
    /*
        T: O(N)
        S: O(H)
    */
    private void inorderRecurse(TreeNode root){
        if(root==null) return;
        inorderRecurse(root.left);
        traverse(root);
        inorderRecurse(root.right);
    }
}