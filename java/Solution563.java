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
class Solution563 {
    int wholeTilt=0;
    
    /*
        T: O(N)
        S: O(H)
    */
    public int findTilt(TreeNode root) {
        sum(root);
        return wholeTilt;
    }
    
    private int sum(TreeNode root){
        if(root==null) return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        wholeTilt+=Math.abs(left-right);
        return root.val+left+right;
    }
}