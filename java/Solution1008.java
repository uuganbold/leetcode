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
class Solution1008 {
    
    /*
        T: O(nLogn)
        S: O(1)
    */
    public TreeNode bstFromPreorder(int[] preorder){
        if(preorder==null|| preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            int val=preorder[i];
            
            TreeNode parent=null;
            TreeNode node=root;
            while(node!=null){
                parent=node;
                if(node.val>val){
                    node=node.left;
                }else{
                    node=node.right;
                }
            }
            
            if(parent.val>val){
                parent.left=new TreeNode(val);
            }else{
                parent.right=new TreeNode(val);
            }
        }
        
        return root;
    }
    
    /*
        T: O(NlogN)
        S: O(logN)
    */
    private void addToTree(TreeNode root, TreeNode parent, int val){
        if(root==null){
            if(parent.val>val){
                parent.left=new TreeNode(val);
            }else{
                parent.right=new TreeNode(val);
            }
        }else{
            if(root.val>val){
                addToTree(root.left,root,val);
            }else{
                addToTree(root.right,root,val);
            }
        }
    }
    
    /*
        T: O(N^2)
        S: O(N)
    */
    public TreeNode bstFromPreorderStack(int[] preorder) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode node=new TreeNode(preorder[i]);
            if(stack.peek().val>node.val){
                stack.peek().left=node;
            }else{
                TreeNode parent=null;
                while(!stack.isEmpty()&&stack.peek().val<node.val){
                    parent=stack.pop();
                }
                parent.right=node;
            }
            stack.push(node);
        }
        
        return root;
    }
}