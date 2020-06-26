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
class Solution1038 {


    public TreeNode bstToGst(TreeNode root) {
        return inorderMorris(root);
    }
    
        /*
        T: O(N)
        S: O(1)
    */
    private TreeNode inorderMorris(TreeNode root){
        
        TreeNode curr=root;
        int sum=0;
        while(curr!=null){
            
            if(curr.right!=null){
                TreeNode temp=curr.right;
                while(temp.left!=null&&temp.left!=curr){
                    temp=temp.left;
                }
                
                if(temp.left==null){
                    temp.left=curr;
                    curr=curr.right;
                }else{
                    temp.left=null;
                    sum+=curr.val;
                    curr.val=sum;
                    curr=curr.left;
                }
                
            }else{
                sum+=curr.val;
                curr.val=sum;
                curr=curr.left;
            }
            
        }
        
        return root;
    }
    
        
    /*
        T: O(N)
        S: O(H)
    */
    private TreeNode inorderStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        
        int sum=0;
        while(curr!=null||!stack.isEmpty()){
            
            while(curr!=null){
                stack.push(curr);
                curr=curr.right;
            }
            
            curr=stack.pop();
            sum+=curr.val;
            curr.val=sum;
            
            curr=curr.left;
        }
        
        return root;
    }
    
    /*
        T: O(N)
        S: O(H)
    */
    private int inorderRecurse(TreeNode root, int greatSum){
        if(root==null){
            return greatSum;
        }
        
        greatSum=inorderRecurse(root.right,greatSum);
        root.val=root.val+greatSum;
        return inorderRecurse(root.left,root.val);
    }
}