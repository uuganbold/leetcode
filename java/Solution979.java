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
class Solution979 {
    int ans;

    /*
        T: O(N)
        S: O(N)
    */
    public int distributeCoins(TreeNode root) {
        this.ans=0;
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left=helper(root.left);
        int right=helper(root.right);
        
        ans+=Math.abs(left)+Math.abs(right);
        
        return left+right+root.val-1; 
    }
}