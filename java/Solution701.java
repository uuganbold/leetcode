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
class Solution701 {

    /*
        T: O(logN)
        S: O(1)
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode=new TreeNode(val);
        if(root==null){
            return newNode;
        }
        
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
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        
        return root;
    }
}