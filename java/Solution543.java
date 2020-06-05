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
class Solution543 {
    int longest=0;
    
    /*
        T: O(N)
        S: O(H)
    */
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return longest;
    }
    
    private int traverse(TreeNode root){
        if(root==null) return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        if(left+right>longest) longest=left+right;
        return Math.max(left,right)+1;
    }
}