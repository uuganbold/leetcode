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
class Solution1315 {

    /*
        T: O(N)
        S: O(H)
    */
    public int sumEvenGrandparent(TreeNode root) {
        dfsRecurse(root,-1,-1);
        return sum;
    }
    
    int sum=0;
    private void dfsRecurse(TreeNode root, int parent, int grandparent){
        if(root==null){
            return;
        }
        if(grandparent%2==0){
            sum+=root.val;
        }
        dfsRecurse(root.left,root.val, parent);
        dfsRecurse(root.right,root.val, parent);
    }
}