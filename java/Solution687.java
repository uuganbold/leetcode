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
class Solution687 {
    int ans=0;
    
    /*
        T: O(N)
        S: O(H)
    */
    public int longestUnivaluePath(TreeNode root) {
         if(root==null){
             return 0;
         }
         helper(root,root.val,0);
         return ans;
    }
    
    private int helper(TreeNode root, int val, int depth){
         if(root==null){
             return 0;
         }
         if(root.val==val){
             int left=helper(root.left,val,depth+1);
             int right=helper(root.right,val,depth+1);
             
             int max=Math.max(left,right);
             ans=Math.max(ans,depth+max);
             ans=Math.max(ans,left+right);
             return max+1;
         }else{
             helper(root,root.val,0);
             return 0;
         }
         
    }
    
}