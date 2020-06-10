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
class Solution110 {

    boolean ans=true;

    /*
        T: O(N)
        S: O(N)
    */
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(!ans||root==null){
            return 0;
        }
        int left=dfs(root.left);
        if(!ans){
            return left;
        }
        int right=dfs(root.right);
        if(!ans){
            return right;
        }
        
        ans=Math.abs(left-right)<=1;
        return Math.max(left,right)+1;
    }
    
    private class Result{
        boolean ans;
        int depth;
        
        public Result(boolean ans, int depth){
            this.ans=ans;
            this.depth=depth;
        }
    }
    
    public Result isBalancedRecurse(TreeNode root){
         if(root==null){
             return new Result(true,0);
         }
        
         Result left=isBalancedRecurse(root.left);
         if(!left.ans){
             return left;
         }
         Result right=isBalancedRecurse(root.right);
         boolean isBalanced=Math.abs(left.depth-right.depth)<=1;
        
         return new Result(left.ans&&right.ans&&isBalanced, Math.max(left.depth, right.depth)+1);
    }
}